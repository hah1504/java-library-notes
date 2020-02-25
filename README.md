# Java Libraries Usage Notes

## Standard Libraries

### String Handling
- Unlike some other languages that implement strings as character arrays, Java implements strings as objects of type String.
- Somewhat unexpectedly, when you create a String object, you are creating a string that cannot be changed. That is, once a String object has been created, you cannot change the characters that comprise that string. At first, this may seem to be a serious restriction. However, such is not the case. You can still perform all types of string operations. The difference is that each time you need an altered version of an existing string, a new Stringobject is created that contains the modifications. The original string is left unchanged. This approach is used because fixed, immutable strings can be implemented more efficiently than changeable ones. 
- The `String`, `StringBuffer`, and `StringBuilder` classes are defined in `java.lang`.
  - All are declared `final`, which means that none of these classes may be subclassed.
- To say that the strings within objects of type String are unchangeable means that the contents of the String instance cannot be changed after it has been created. However, a variable declared as a String reference can be changed to point at some other String object at any time.
- String Constructors
  - To create an empty string: `String s = new String();`
  - To create a String initialized by an array of characters: `String(char chars[ ])`
  - 

