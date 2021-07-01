class Authenticator:

    @staticmethod
    def authenticate(user_id, password):
        if user_id == 'admin' and password == 'pass':
            return True
        return False
