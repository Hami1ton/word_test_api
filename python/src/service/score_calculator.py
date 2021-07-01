from flask import g


class ScoreCalculator:

    @staticmethod
    def calculate(answer_dict):
        score = 0
        eword_id_list = answer_dict.keys()
        for eword_id in eword_id_list:
            user_answer = answer_dict[eword_id]
            # 英単語IDによってdbから意味を取得
            # TODO 別メソッド切り出すなどしてテストしやすくする
            cur = g.db.execute('select meaning from english_words_and_meanings where id = ' + eword_id)
            correct_answer = cur.fetchall()[0][0]
            if user_answer == correct_answer:
                score += 1
        return score
