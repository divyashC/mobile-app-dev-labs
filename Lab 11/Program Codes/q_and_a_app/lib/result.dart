import 'package:flutter/material.dart';

class Result extends StatelessWidget {
  final int resultScore;
  final Function resetHandler;
  // ignore: prefer_const_constructors_in_immutables
  Result(this.resultScore, this.resetHandler, {super.key});

  String get resultPhrase {
    String resultText;
    if (resultScore == 30) {
      resultText = 'We should be friend!';
    } else if (resultScore == 20) {
      resultText = 'Getting there try again!';
    } else {
      resultText = 'Get Help';
    }
    return resultText;
  }

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        children: <Widget>[
          const SizedBox(
            height: 10,
          ),
          Container(
            margin: const EdgeInsets.fromLTRB(15, 50, 15, 10),
            child: Text(
              "Remarks - $resultPhrase",
              style: const TextStyle(
                fontSize: 25,
              ),
              textAlign: TextAlign.center,
            ),
          ),
          Container(
            margin: const EdgeInsets.fromLTRB(15, 10, 15, 70),
            child: Text("Total Score - $resultScore / 30",
                style: const TextStyle(
                  fontSize: 30,
                  fontWeight: FontWeight.bold,
                ),
                textAlign: TextAlign.center),
          ),
          TextButton(
            onPressed: (() => resetHandler()),
            style: TextButton.styleFrom(
                foregroundColor: Colors.white, backgroundColor: Colors.blue),
            child: const Text('Restart Quiz!',
                style: TextStyle(
                  fontSize: 20,
                )),
          )
        ],
      ),
    );
  }
}
