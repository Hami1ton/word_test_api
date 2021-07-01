import sqlite3
from flask import request, g, \
    make_response, jsonify
from contextlib import closing

from app_factory import create_app
from route.app_urls import WORD_TEST_URL, LOGIN_URL, SCORING_URL
from service.problems_creator import ProblemsCreator
from service.authenticator import Authenticator
from src.service.score_calculator import ScoreCalculator

NUMBER_OF_QUESTIONS = 5
app = create_app("config/app_config.py")


def connect_db():
    return sqlite3.connect(app.config['DATABASE'])


def init_db():
    with closing(connect_db()) as db:
        with app.open_resource('schema.sql') as f1:
            db.cursor().executescript(f1.read().decode('utf-8'))

        # データを挿入
        with open("db/Words.txt", mode="r") as f2:
            word_list = [s.strip() for s in f2.readlines()]

        with open("db/Meanings.txt", mode="r") as f3:
            meaning_list = [s.strip() for s in f3.readlines()]

        for i in range(len(word_list) - 1):
            db.execute('insert into english_words_and_meanings (word, meaning) values (?, ?)',
                       [word_list[i], meaning_list[i]])
        db.commit()


@app.before_request
def before_request():
    g.db = connect_db()


@app.after_request
def after_request(response):
    g.db.close()
    # CORSの許可
    response.headers.add('Access-Control-Allow-Origin', '*')
    response.headers.add('Access-Control-Allow-Headers', 'Content-Type,Authorization')
    response.headers.add('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE,OPTIONS')
    return response


@app.route(LOGIN_URL, methods=['GET', 'POST'])
def login():
    result = Authenticator.authenticate(request.json['userId'], request.json['password'])
    if not result:
        return make_response(jsonify('invalid userId or password'), 404)

    return make_response(jsonify({'result': 'success'}))


# @app.route(LOGOUT_URL)
# def logout():
#     session.pop('logged_in', None)
#     flash('You were logged out')
#     return redirect(url_for('login'))


@app.route(WORD_TEST_URL, methods=['GET'])
def start_test():
    # TODO 問題数を変えられるようにしたい
    # problem_listは、[id, 英単語,[選択肢1, 2, 3]]のリスト
    creator = ProblemsCreator(NUMBER_OF_QUESTIONS)
    result = creator.create_question_list()
    return make_response(jsonify(result))


@app.route(SCORING_URL, methods=['POST'])
def show_result():
    calculator = ScoreCalculator()
    score = calculator.calculate(request.json)
    return make_response(jsonify(score))


if __name__ == '__main__':
    init_db()
    app.run()
    # print(app.config["PASSWORD"])
