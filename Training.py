import random
import json
import pickle
import numpy as np

import nltk
from nltk.stem import WordNetLemmatizer

# Para crear la red neuronal
import tensorflow as tf
from tensorflow import keras
#from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense, Dropout
from tensorflow.keras.optimizers.legacy import SGD



lemmatizer = WordNetLemmatizer()

intents = json.loads(open('Diccionario.json').read())

nltk.download('punkt')
nltk.download('wordnet')
nltk.download('omw-1.4')

words = []
classes = []
documents = []
ignore_letters = ['?', '!', '¿', '.', ',']

# Clasifica los patrones y las categorías
for intent in intents['intents']:
    for pattern in intent['patterns']:
        word_list = nltk.word_tokenize(pattern)
        words.extend(word_list)
        documents.append((word_list, intent["tag"]))
        if intent["tag"] not in classes:
            classes.append(intent["tag"])

words = [lemmatizer.lemmatize(word) for word in words if word not in ignore_letters]
words = sorted(set(words))

pickle.dump(words, open('words.pkl', 'wb'))
pickle.dump(classes, open('classes.pkl', 'wb'))

# Pasa la información a unos y ceros según las palabras presentes en cada categoría para hacer el entrenamiento
training = []
output_empty = [0] * len(classes)

for document in documents:
    bag = [0] * len(words)
    word_patterns = document[0]
    word_patterns = [lemmatizer.lemmatize(word.lower()) for word in word_patterns]

    for word in word_patterns:
        if word in words:
            bag[words.index(word)] = 1

    output_row = list(output_empty)
    output_row[classes.index(document[1])] = 1
    training.append((bag, output_row))

# Crear arreglos numpy vacíos
train_x = np.zeros((len(training), len(words)))
train_y = np.zeros((len(training), len(classes)))

# Llenar los arreglos con los valores correspondientes
for i in range(len(training)):
    bag, output_row = training[i]
    train_x[i] = bag
    train_y[i] = output_row

# Reparte los datos para pasarlos a la red
train_x = np.array([item[0] for item in training])
train_y = np.array([item[1] for item in training])

# Creamos la red neuronal
model = Sequential()
model.add(Dense(128, input_shape=(len(train_x[0]),), activation='relu'))
model.add(Dropout(0.5))
model.add(Dense(64, activation='relu'))
model.add(Dropout(0.5))
model.add(Dense(len(train_y[0]), activation='softmax'))

# Creamos el optimizador y lo compilamos
sgd = SGD(learning_rate=0.001, decay=1e-6, momentum=0.9, nesterov=True) #Modificado por version
model.compile(loss='categorical_crossentropy', optimizer=sgd, metrics=['accuracy'])

# Entrenamos el modelo y lo guardamos
model.fit(np.array(train_x), np.array(train_y), epochs=100, batch_size=5, verbose=1)
model.save("chatbot_model.h5")

# Después de que el modelo ha sido entrenado
weights = model.get_weights()

# Muestra los pesos para cada capa
for i in range(len(weights)):
    print(f"Capa {i+1} - Pesos:")
    print(weights[i])