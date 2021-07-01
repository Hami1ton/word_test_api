from service.authenticator import Authenticator

def test_authenticate():
    assert Authenticator.authenticate('admin', 'password')
    assert not Authenticator.authenticate('user', 'password')
    