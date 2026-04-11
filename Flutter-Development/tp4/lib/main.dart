import 'package:flutter/material.dart';
import 'models/contact.dart'; // Make sure this matches your folder structure

const darkBlueColor = Color(0xFF486579);

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Contact App',
      theme: ThemeData(primaryColor: darkBlueColor),
      home: const MyHomePage(title: 'Contact List'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  final String title;
  const MyHomePage({super.key, required this.title});

  @override
  State<MyHomePage> createState() => MyHomePageState();
}

class MyHomePageState extends State<MyHomePage> {
  final _formKey = GlobalKey<FormState>();

  Contact _contact = Contact();
  final List<Contact> _contacts = [];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.grey[200],
      appBar: AppBar(
        backgroundColor: Colors.white,
        title: Center(
          child: Text(
            widget.title,
            style: const TextStyle(color: darkBlueColor),
          ),
        ),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          children: <Widget>[_form(), _list()],
        ),
      ),
    );
  }

  Widget _form() => Container(
    color: Colors.white,
    padding: const EdgeInsets.symmetric(vertical: 15, horizontal: 30),
    child: Form(
      key: _formKey,
      child: Column(
        children: <Widget>[
          TextFormField(
            decoration: const InputDecoration(labelText: 'Full Name'),
            validator: (val) =>
                (val == null || val.isEmpty) ? 'This field is mandatory' : null,
            onSaved: (val) => setState(() => _contact.name = val),
          ),
          TextFormField(
            decoration: const InputDecoration(labelText: 'Mobile'),
            keyboardType: TextInputType.phone,
            validator: (val) => (val == null || val.length < 10)
                ? '10 characters required'
                : null,
            onSaved: (val) => setState(() => _contact.mobile = val),
          ),
          Container(
            margin: const EdgeInsets.all(10.0),
            child: ElevatedButton(
              style: ElevatedButton.styleFrom(
                backgroundColor: darkBlueColor,
                foregroundColor: Colors.white,
              ),
              onPressed: () => _onSubmit(),
              child: const Text('Submit'),
            ),
          ),
        ],
      ),
    ),
  );

  void _onSubmit() {
    var form = _formKey.currentState;
    if (form != null && form.validate()) {
      form.save();

      print('''
      Full Name: ${_contact.name}
      Mobile: ${_contact.mobile}
      ''');

      setState(() {
        _contacts.add(
          Contact(id: null, name: _contact.name, mobile: _contact.mobile),
        );
      });

      form.reset();
    }
  }

  Widget _list() => Expanded(
    child: Card(
      margin: const EdgeInsets.fromLTRB(20, 30, 20, 0),
      child: Scrollbar(
        child: ListView.builder(
          padding: const EdgeInsets.all(8),
          itemCount: _contacts.length,
          itemBuilder: (context, index) {
            return Column(
              children: <Widget>[
                ListTile(
                  leading: const Icon(
                    Icons.account_circle,
                    color: darkBlueColor,
                    size: 40.0,
                  ),
                  title: Text(
                    _contacts[index].name?.toUpperCase() ?? 'UNKNOWN',
                    style: const TextStyle(
                      color: darkBlueColor,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  subtitle: Text(_contacts[index].mobile ?? 'No mobile'),
                  onTap: () {},
                ),
                const Divider(height: 5.0),
              ],
            );
          },
        ),
      ),
    ),
  );
}
