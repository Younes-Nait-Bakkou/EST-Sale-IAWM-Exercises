import 'package:flutter/material.dart';
import 'models/contact.dart';

// The TP asks for a specific hex color.
// In Flutter, we replace the '#' in a hex code with '0xFF' (the FF means 100% opacity).
const darkBlueColor = Color(0xFF486579);

void main() {
  runApp(const MyApp());
}

// MyApp is a StatelessWidget because its core configuration doesn't change over time.
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

// 1. The StatefulWidget itself. It accepts a title from MyApp.
class MyHomePage extends StatefulWidget {
  final String title;

  const MyHomePage({super.key, required this.title});

  @override
  State<MyHomePage> createState() => MyHomePageState();
}

// 2. The State class. This is where the actual data and UI live.
class MyHomePageState extends State<MyHomePage> {
  // --- STATE VARIABLES ---
  // _contact will temporarily hold the data while the user types it in the form.
  Contact _contact = Contact();

  // _contacts is the master list that will store all the saved contacts.
  List<Contact> _contacts = [];

  final _formKey = GlobalKey<FormState>();

  // --- UI BUILDER ---
  @override
  Widget build(BuildContext context) {
    // Scaffold provides the standard layout structure (AppBar, Body, etc.)
    return Scaffold(
      backgroundColor: Colors.grey[200],
      appBar: AppBar(
        backgroundColor: Colors.white,
        title: Center(
          child: Text(
            widget
                .title, // This grabs the title "Contact List" from the widget above
            style: const TextStyle(color: darkBlueColor),
          ),
        ),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          children: <Widget>[
            _form(), // Calling the form placeholder
            _list(), // Calling the list placeholder
          ],
        ),
      ),
    );
  }

  // --- PLACEHOLDER WIDGETS ---
  // We will build these out in the next steps!
  Widget _form() => Container(
    color: Colors.white,
    padding: const EdgeInsets.symmetric(vertical: 15, horizontal: 30),
    child: Form(
      key: _formKey, // We link the key here
      child: Column(
        children: <Widget>[
          // --- FULL NAME INPUT ---
          TextFormField(
            decoration: const InputDecoration(labelText: 'Full Name'),
            // Validation: Checks if the input is null or empty
            validator: (val) =>
                (val == null || val.isEmpty) ? 'This field is mandatory' : null,
            // OnSaved: Triggers when we call form.save() later
            onSaved: (val) => setState(() => _contact.name = val),
          ),

          // --- MOBILE INPUT ---
          TextFormField(
            decoration: const InputDecoration(labelText: 'Mobile'),
            keyboardType: TextInputType.phone, // Pops up a number keyboard!
            // Validation: Checks if the number is at least 10 characters
            validator: (val) => (val == null || val.length < 10)
                ? '10 characters required'
                : null,
            onSaved: (val) => setState(() => _contact.mobile = val),
          ),
          // --- SUBMIT BUTTON ---
          Container(
            margin: const EdgeInsets.all(10.0),
            child: ElevatedButton(
              // Modern replacement for RaisedButton
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

    // 1. Check if the form passes our validation rules
    if (form != null && form.validate()) {
      // 2. Trigger the 'onSaved' functions in our TextFormFields
      form.save();

      // 3. Print to the debug console (just like the TP asks)
      print('''
      Full Name: ${_contact.name}
      Mobile: ${_contact.mobile}
      ''');

      // 4. Add a NEW instance of Contact to our list and update the UI
      setState(() {
        _contacts.add(
          Contact(id: null, name: _contact.name, mobile: _contact.mobile),
        );
      });

      // 5. Clear the text fields for the next entry
      form.reset();
    }
  }

  Widget _list() => Expanded(
    child: Card(
      margin: const EdgeInsets.fromLTRB(20, 30, 20, 0),
      child: Scrollbar(
        child: ListView.builder(
          padding: const EdgeInsets.all(8),
          // itemCount tells Flutter exactly how many rows to draw
          itemCount: _contacts.length,
          // itemBuilder draws the UI for each individual row
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
                    // We use ? and ?? to safely handle potential null values
                    _contacts[index].name?.toUpperCase() ?? 'UNKNOWN',
                    style: const TextStyle(
                      color: darkBlueColor,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  subtitle: Text(_contacts[index].mobile ?? 'No mobile'),
                  onTap: () {}, // We will use this in the future for editing!
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
