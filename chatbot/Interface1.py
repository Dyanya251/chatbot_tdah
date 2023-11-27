from kivy.app import App
from kivy.uix.screenmanager import ScreenManager, Screen
from kivy.uix.label import Label
from kivy.uix.button import Button
from kivy.uix.textinput import TextInput
from kivy.uix.boxlayout import BoxLayout

class WelcomeScreen(Screen):
    def __init__(self, **kwargs):
        super(WelcomeScreen, self).__init__(**kwargs)
        layout = self.create_layout()
        self.add_widget(layout)

    def create_layout(self):
        layout = BoxLayout(orientation='vertical', padding=10, spacing=10)
        label = Label(text='¡Bienvenido a la aplicación!', font_size=20)
        register_button = Button(text='Registrarse', on_press=self.go_to_registration)
        # Elimina la referencia a go_to_login
        layout.add_widget(label)
        layout.add_widget(register_button)
        return layout

    def go_to_registration(self, instance):
        self.manager.current = 'registration'


class RegistrationScreen(Screen):
    def __init__(self, **kwargs):
        super(RegistrationScreen, self).__init__(**kwargs)
        layout = self.create_layout()
        self.add_widget(layout)

    def create_layout(self):
        layout = BoxLayout(orientation='vertical', padding=10, spacing=10)
        label = Label(text='Registro', font_size=20)
        username_input = TextInput(hint_text='Nombre de usuario', multiline=False)
        register_button = Button(text='Registrarse', on_press=self.perform_registration)
        back_button = Button(text='Volver', on_press=self.go_to_welcome)
        layout.add_widget(label)
        layout.add_widget(username_input)
        layout.add_widget(register_button)
        layout.add_widget(back_button)
        return layout

    def perform_registration(self, instance):
        # Lógica para el registro (puedes agregar la lógica real aquí)
        print('Registro exitoso!')
        self.go_to_welcome()

def go_to_welcome(self, instance=None):
    self.manager.current = 'welcome'

class ChatbotApp(App):
    def build(self):
        screen_manager = ScreenManager()
        welcome_screen = WelcomeScreen(name='welcome')
        registration_screen = RegistrationScreen(name='registration')
        screen_manager.add_widget(welcome_screen)
        screen_manager.add_widget(registration_screen)
        return screen_manager


if __name__ == '__main__':
    ChatbotApp().run()