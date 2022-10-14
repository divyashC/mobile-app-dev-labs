import 'package:flutter/material.dart';
import './quiz.dart';
import './result.dart';

void main() => runApp(
      const MyApp(),
    );

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<StatefulWidget> createState() {
    return MyAppState();
  }
}

class MyAppState extends State<MyApp> {
  final _questions = const [
    {
      'questionText': 'Capital of Finland is _________',
      'answers': [
        {'text': 'Helsinki', 'score': 10},
        {'text': 'Tokyo', 'score': 0},
        {'text': 'Cairo', 'score': 0},
        {'text': 'Tehran', 'score': 0},
      ],
    },
    {
      'questionText': 'When was flutter released?',
      'answers': [
        {'text': '2020', 'score': 0},
        {'text': '2019', 'score': 0},
        {'text': '2018', 'score': 10},
        {'text': '2017', 'score': 0},
      ],
    },
    {
      'questionText': 'Who is the father of computer?',
      'answers': [
        {'text': 'Bill Gates', 'score': 0},
        {'text': 'Charles Babbage', 'score': 10},
        {'text': 'Elon Musk', 'score': 0},
        {'text': 'Alan Turing', 'score': 0},
      ],
    }
  ];

  var _questionIndex = 0;
  var _totalScore = 0;
  void _resetQuiz() {
    setState(() {
      _questionIndex = 0;
      _totalScore = 0;
    });
  }

  void _answerQuestion(int score) {
    _totalScore += score;

    setState(() {
      _questionIndex = _questionIndex + 1;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Quiz App'),
        ),
        body: SafeArea(
          child: _questionIndex < _questions.length
              ? Quiz(
                  answerQuestion: _answerQuestion,
                  questionIndex: _questionIndex,
                  questions: _questions,
                )
              : Result(_totalScore, _resetQuiz),
        ),
      ),
    );
  }
}
