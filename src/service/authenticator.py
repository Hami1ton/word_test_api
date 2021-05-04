class Authenticator:

    def authenticate(userId, password):
        if userId == 'admin' and password == 'password':
            return True
        return False