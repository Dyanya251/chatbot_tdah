import random
import json
import pickle
import numpy as np
import sys
import nltk
from nltk.stem import WordNetLemmatizer

from keras.models import load_model

lemmatizer = WordNetLemmatizer()


words = pickle.load(open('words.pkl', 'rb'))
classes = pickle.load(open('classes.pkl', 'rb'))
model = load_model('chatbot_model.h5')

intents_json = json.loads(open('Diccionario.json', 'r', encoding='utf-8').read())


def clean_up_sentence(sentence):
    sentence_words = nltk.word_tokenize(sentence)
    sentence_words = [lemmatizer.lemmatize(word) for word in sentence_words]
    return sentence_words

def bag_of_words(sentence):
    sentence_words = clean_up_sentence(sentence)
    bag = [0] * len(words)
    for w in sentence_words:
        for i, word in enumerate(words):
            if word == w:
                bag[i] = 1
    return np.array(bag)

def predict_class(sentence):
    bow = bag_of_words(sentence)
    res = model.predict(np.array([bow]))[0]
    max_index = np.where(res == np.max(res))[0][0]
    category = classes[max_index]
    return category

def get_response(tag, intents_json):
    list_of_intents = intents_json['intents']
    result = ""
    for i in list_of_intents:
        if i["tag"] == tag:
            result = random.choice(i['responses'])
            break
    return result

#Ejecutamos el chat en bucle
while True:
    message = input("Usuario: ")

    if message.lower() == "salir":
        print("Chatbot: ¡Hasta luego!")
        break

    predicted_intent_tag = predict_class(message)

    if predicted_intent_tag:

        if predicted_intent_tag == "DiagnosticoTDAH":
            sintomas_afirmativos = 0
            # Iterar sobre los síntomas esperados: 5
            for sintoma in intents_json['intents'][10]['sintomas']: 
                if sintoma['respuesta'].lower() in message.lower():
                    print(f"Usuario: Sí, tengo {sintoma['nombre']}")
                    sintomas_afirmativos += 1

            if sintomas_afirmativos >= 5:
                print("Chatbot: Parece que tienes al menos 5 síntomas asociados con TDAH. Quieres que te explique un poco mas sobre eso?.")
                #if message.lower() == "Si deseo mas información":
            else:
                print("Chatbot: Gracias por hablar conmigo, y no tienes signos de tener TDAH :). ¿Hay algo más en lo que pueda ayudarte?")
        else:
              response = get_response(predicted_intent_tag, intents_json)
        
        print(f"Chatbot: {response}")
    else:
        print("Chatbot: No entendí tu pregunta :( ¿Podrias escribirla de otra forma?")