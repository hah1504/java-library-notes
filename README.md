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
  - You can specify a subrange of a character array as an initializer using the following constructor: `String(char chars[ ], int startIndex, int numChars)`. Here, startIndex specifies the index at which the subrange begins, and numChars specifies the number of characters to use. 
  - You can construct a String object that contains the same character sequence as another String object: `String(String strObj)`.
  - [Constructing Strings](https://github.com/zed1025/java-library-notes/blob/master/constructingStrings.java)
- Even though Java’s char type uses 16 bits to represent the basic Unicode character set, the typical format for strings on the Internet uses arrays of 8-bit bytes constructed from the ASCII character set. Because 8-bit ASCII strings are common, the String class provides constructors that initialize a string when given a byte array. 
  - `String(byte chrs[ ])`
  - `String(byte chrs[ ], int startIndex, int numChars)`
  - Here, chrs specifies the array of bytes. The second form allows you to specify a subrange. In each of these constructors, the byte-to-character conversion is done by using the default character encoding of the platform. 
  - [Byte to String](https://github.com/zed1025/java-library-notes/blob/master/byteToString.java)
- The contents of the array are copied whenever you create a String object from an array. If you modify the contents of the array after you have created the string, the String will be unchanged.
- You can construct a String from a StringBuffer: `String(StringBuffer strBufObj)`
- You can construct a String from a StringBuilder: `You can construct a String from a StringBuilder`
- **String length**: The length of a string is the number of characters that it contains. o obtain this value, call the `length( )` method. 
  - [String Length](https://github.com/zed1025/java-library-notes/blob/master/stringLength.java)
- Java does not allow operators to be applied to String objects. The one exception to this rule is the + operator, which **concatenates** two strings, producing a String object as the result. This allows you to chain together a series of + operations.
- When Java converts data into its string representation during concatenation, it does so by calling one of the overloaded versions of the string conversion method `valueOf( )` defined by String. `valueOf( )` is overloaded for all the primitive types and for type Object. For the primitive types, `valueOf( )` returns a string that contains the human-readable equivalent of the value with which it is called. For objects, `valueOf( )` calls the `toString( )` method on the object. More on valueOf( ) later.
- Every class implements toString( ) because it is defined by Object. However, the default implementation of toString( ) is seldom sufficient. For most important classes that you create, you will want to override toString( ) and provide your own string representations. Fortunately, this is easy to do. The toString( ) method has this general form: `String toString( )`. [toString Demo](https://github.com/zed1025/java-library-notes/blob/master/toStringDemo.java)
- **Character Extraction from String**:
  - Although the characters that comprise a string within a String object cannot be indexed as if they were a character array, many of the String methods employ an index (or offset) into the string for their operation. Like arrays, the string indexes begin at zero.
  - To extract a single character from a String, you can refer directly to an individual character via the charAt( ) method. General form: `char charAt(int where)`.
  - If you need to extract more than one character at a time, you can use the `getChars( )` method. General form: `void getChars(int sourceStart, int sourceEnd, char target[ ], int targetStart)`. Here, sourceStart specifies the index of the beginning of the substring, and sourceEndspecifies an index that is one past the end of the desired substring. Thus, the substring contains the characters from sourceStart through sourceEnd–1. The array that will receive the characters is specified by target. The index within target at which the substring will be copied is passed in targetStart. Care must be taken to assure that the target array is large enough to hold the number of characters in the specified substring. [getCharsDemo](https://github.com/zed1025/java-library-notes/blob/master/getCharsDemo.java) 
  - There is an alternative to getChars( ) that stores the characters in an array of bytes. This method is called `getBytes( )`, and it uses the default character-to-byte conversions provided by the platform. General form: `byte[ ] getBytes( )`. getBytes( ) is most useful when you are exporting a String value into an environment that does not support 16-bit Unicode characters. For example, most Internet protocols and text file formats use 8-bit ASCII for all text interchange.
  - If you want to convert all the characters in a String object into a character array, the easiest way is to call `toCharArray( )`. It returns an array of characters for the entire string. General form: `char[ ] toCharArray( )`. This function is provided as a convenience, since it is possible to use getChars( ) to achieve the same result. [toCharArray Demo](https://github.com/zed1025/java-library-notes/blob/master/toCharArrayDemo.java)
- **String Comparison**:
  - To compare two strings for equality, use equals( ). General form: `boolean equals(Object str)`. Here, str is the String object being compared with the invoking String object. It returns true if the strings contain the same characters in the same order, and false otherwise. The comparison is case-sensitive.
  - To perform a comparison that ignores case differences, call equalsIgnoreCase( ). Genral form: `boolean equalsIgnoreCase(String str)`. [Equals and EqualsIgnoreCase Demo](https://github.com/zed1025/java-library-notes/blob/master/equalsDemo.java)
  - The regionMatches( ) method compares a specific region inside a string with another specific region in another string. There is an overloaded form that allows you to ignore case in such comparisons. General form: 
    - `boolean regionMatches(int startIndex, String str2, int str2StartIndex, int numChars)`
    - `boolean regionMatches(boolean ignoreCase, int startIndex, String str2, int str2StartIndex, int numChars)`
    - For both versions, startIndex specifies the index at which the region begins within the invoking String object. The String being compared is specified by str2. The index at which the comparison will start within str2 is specified by str2StartIndex. The length of the substring being compared is passed in numChars. In the second version, if ignoreCase is true, the case of the characters is ignored. Otherwise, case is significant.
    - [Region Matches Demo]()
  - String defines two methods that are, more or less, specialized forms of regionMatches( ). The startsWith( ) method determines whether a given String begins with a specified string. Conversely, endsWith( ) determines whether the String in question ends with a specified string. They have the following general forms:
    - `boolean startsWith(String str)`
    - `boolean endsWith(String str)`
    - A second form of startsWith( ), shown here, lets you specify a starting point: `boolean startsWith(String str, int startIndex)`
    - [Starts/Ends With Demo](https://github.com/zed1025/java-library-notes/blob/master/startsEndsWithDemo.java)
  - Difference between `equals()` and `==`
    - `equals( )` method compares the characters inside a String object.
    - The `==` operator compares two object references to see whether they refer to the same instance. 
    - [equalsNotEqualTo](https://github.com/zed1025/java-library-notes/blob/master/equalsOperatorVsMethod.java)
  - Often, it is not enough to simply know whether two strings are identical. You need to know which is less than, equalto, or greater than the next. A string is less than another if it comes before the other in dictionary order. A string is greater than another if it comes after the other in dictionary order. The method compareTo( ) serves this purpose. It is specified by the Comparable<T> interface, which String implements. It has this general form: `int compareTo(String str)`. Here, str is the String being compared with the invoking String. The result of the comparison is returned and is interpreted as shown here: ![](compareTo.png).
    - [Bubble sort using compareTo](https://github.com/zed1025/java-library-notes/blob/master/bubbleSortOfStrings.java)
    - `compareTo( )` takes into account uppercase and lowercase letters.
    - If you want to ignore case differences when comparing two strings, use `compareToIgnoreCase( )`, general form: `int compareToIgnoreCase(String str)`
- **Searching Strings**:
  - The String class provides two methods that allow you to search a string for a specified character or substring:
    - `indexOf( )`:  Searches for the first occurrence of a character or substring
    - `lastIndexOf( )`: Searches for the last occurrence of a character or substring
    - the methods return the index at which the character or substring was found, or –1 on failure.
    - To search for the first occurrence of a character, use: `int indexOf(int ch)`. Here, ch is the character being sought.
    - To search for the last occurrence of a character, use: `int lastIndexOf(int ch)`. Here, ch is the character being sought.
    - To search for the first or last occurrence of a substring, use: `int indexOf(String str)`, and `int lastIndexOf(String str)`.
    - You can specify a starting point for the search using these forms: `int indexOf(String str, int startIndex)`. Will work for chars and lastIndexOf too
    - [Searching Strings](https://github.com/zed1025/java-library-notes/blob/master/indexOfMethod.java)
- **Modifying a String**:
  - Because String objects are immutable, whenever you want to modify a String, you must either copy it into a StringBuffer or StringBuilder, or use a String method that constructs a new copy of the string with your modifications complete.
  - You can extract a substring using `substring( )`. It has two forms
    - `String substring(int startIndex)`
    - `String substring(int startIndex, int endIndex)`
    - The following program uses substring( ) to replace all instances of one substring with another within a string: [Substring Demo](https://github.com/zed1025/java-library-notes/blob/master/substringDemo.java)
  - You can concatenate two strings using concat( ). General form: `String concat(String str)`. concat( ) performs the same function as `+`.
    ```
    String s1 = "one";
    String s2 = s1.concat("two");
    ```
  - `replace()`, has two general forms. 
    - The first replaces all occurrences of one character in the invoking string with another character. `String replace(char original, char replacement)`
    - The second form of replace( ) replaces one character sequence with another. It has this general form: `String replace(CharSequence original, CharSequence replacement)`
    - [Replace Demo](https://github.com/zed1025/java-library-notes/blob/master/replaceDemo.java)
  - The `trim( )` method returns a copy of the invoking string from which any leading and trailing whitespace has been removed. General form: `String trim( )`.
    - Simple usage: `String s = "   Hello World    ".trim();`.
    - The trim( ) method is quite useful when you process user commands. For example, the following program prompts the user for the name of a state and then displays that state’s capital. It uses trim( ) to remove any leading or trailing whitespace that may have inadvertently been entered by the user.
    - [Trim Demo](https://github.com/zed1025/java-library-notes/blob/master/trimDemo.java)
- `valueOf( )`
  - The valueOf( ) method converts data from its internal format into a human-readable form. It is a static method that is overloaded within String for all of Java’s built-in types so that each type can be converted properly into a string. 
  - valueOf( ) is also overloaded for type Object, so an object of any class type you create can also be used as an argument.
  - Some forms of valueOf()
    - `static String valueOf(double num)`
    - `static String valueOf(long num)`
    - `static String valueOf(Object ob)`
    - `static String valueOf(char chars[ ])`
  - As discussed earlier, valueOf( ) is called when a string representation of some other type of data is needed—for example, during concatenation operations. You can call this method directly with any data type and get a reasonable String representation. All of the simple types are converted to their common String representation. Any object that you pass to valueOf( ) will return the result of a call to the object’s toString( ) method. In fact, you could just call toString( ) directly and get the same result.
  - For most arrays, valueOf( ) returns a rather cryptic string, which indicates that it is an array of some type. For arrays of char, however, a String object is created that contains the characters in the char array. There is a special version of valueOf( ) that allows you to specify a subset of a char array. It has this general form: `static String valueOf(char chars[ ], int startIndex, int numChars)`
    - Here, chars is the array that holds the characters, startIndex is the index into the array of characters at which the desired substring begins, and numChars specifies the length of the substring.
- **Changing Case of Characters within strings**:
  - The method toLowerCase( ) converts all the characters in a string from uppercase to lowercase. The toUpperCase( ) method converts all the characters in a string from lowercase to uppercase. 
  - [Case Changing](https://github.com/zed1025/java-library-notes/blob/master/changeCases.java)
  - verloaded versions of toLowerCase( ) and toUpperCase( ) that let you specify a `Locale` object to govern the conversion are also supplied. Specifying the locale can be quite important in some cases and can help internationalize your application.
- JDK 8 adds a new method to String called join( ). It is used to concatenate two or more strings, separating each string with a delimiter, such as a space or a comma. It has two forms. Its first is shown here: `static String join(CharSequence delim, CharSequence . . . strs)`. Here, delim specifies the delimiter used to separate the character sequences specified by strs. Because String implements the CharSequence interface, strs can be a list of strings.
  - The second form of join( ) lets you join a list of strings obtained from an object that implements the Iterable interface. 
  - [Join Demo](https://github.com/zed1025/java-library-notes/blob/master/joinDemo.java)
- Some more methods
  - `boolean contains(CharSequence str)`: Returns true if the invoking object contains the string specified by str. Returns false otherwise.
  - `boolean isEmpty( )`: Returns true if the invoking string contains no characters and has a length of zero. 
  - `boolean matches(string regExp)`: Returns true if the invoking string matches the regular expression passed in regExp. Otherwise, returns false
  - `String replaceAll(String regExp, String newStr)`: Returns a string in which all substrings that match the regular expression specified by regExp are replaced by newStr.
- `StringBuffer` Intro:
  - StringBuffer supports a modifiable string. As you know, String represents fixed-length, immutable character sequences. In contrast, StringBuffer represents growable and writable character sequences. StringBuffer may have characters and substrings inserted in the middle or appended to the end. StringBuffer will automatically grow to make room for such additions and often has more characters preallocated than are actually needed, to allow room for growth.
  - StringBuffer constructors
    - `StringBuffer( )`. The default constructor (the one with no parameters) reserves room for 16 characters without reallocation. 
    - `StringBuffer(int size)`. The second version accepts an integer argument that explicitly sets the size of the buffer. 
    - `StringBuffer(String str)`: The third version accepts a String argument that sets the initial contents of the StringBuffer object and reserves room for 16 more characters without reallocation. (StringBuffer allocates room for 16 additional characters when no specific buffer length is requested, because reallocation is a costly process in terms of time. Also, frequent reallocations can fragment memory. By allocating room for a few extra characters, StringBuffer reduces the number of reallocations that take place.)
    - `StringBuffer(CharSequence chars)`: The fourth constructor creates an object that contains the character sequence contained in chars and reserves room for 16 more characters.
  - The current length of a StringBuffer can be found via the `length( )` method, while the total allocated capacity can be found through the `capacity( )` method. [StringBuffer length vs. capacity](https://github.com/zed1025/java-library-notes/blob/master/lengthVsCapacity.java)
  - If you want to preallocate room for a certain number of characters after a StringBuffer has been constructed, you can use `ensureCapacity( )` to set the size of the buffer. This is useful if you know in advance that you will be appending a large number of small strings to a StringBuffer. ensureCapacity( ) has this general form: `void ensureCapacity(int minCapacity)`. Here, minCapacity specifies the minimum size of the buffer. (A buffer larger than minCapacitymay be allocated for reasons of efficiency.) [StringBuffer Ensuring Capacity](https://github.com/zed1025/java-library-notes/blob/master/ensureCap.java). [More](https://www.geeksforgeeks.org/stringbuffer-ensurecapacity-method-in-java-with-examples/)
  - To set the length of the string within a StringBuffer object, use `setLength( )`. General form: `void setLength(int len)`. Here, len specifies the length of the string. This value must be nonnegative. When you increase the size of the string, null characters are added to the end. If you call setLength( ) with a value less than the current value returned by length( ), then the characters stored beyond the new length will be lost.
  - The value of a single character can be obtained from a StringBuffer via the `charAt( )` method. You can set the value of a character within a StringBuffer using `setCharAt( )`. General forms: `char charAt(int where)` and `void setCharAt(int where, char ch)`. For charAt( ), where specifies the index of the character being obtained. For setCharAt( ), where specifies the index of the character being set, and ch specifies the new value of that character. For both methods, where must be nonnegative and must not specify a location beyond the end of the string. [StringBuffer Using Character At](https://github.com/zed1025/java-library-notes/blob/master/setCharAtDemo.java)
  - To copy a substring of a StringBuffer into an array, use the getChars( ) method. It has this general form: `void getChars(int sourceStart, int sourceEnd, char target[ ], int targetStart)`. Here, sourceStart specifies the index of the beginning of the substring, and sourceEndspecifies an index that is one past the end of the desired substring. This means that the substring contains the characters from sourceStart through sourceEnd–1. The array that will receive the characters is specified by target. The index within target at which the substring will be copied is passed in targetStart. Care must be taken to assure that the target array is large enough to hold the number of characters in the specified substring.
  - The append( ) method concatenates the string representation of any other type of data to the end of the invoking StringBuffer object. It has several overloaded versions. Here are a few of its forms: 
    - `StringBuffer append(String str)`
    - `StringBuffer append(int num)`
    - `StringBuffer append(Object obj)`
    - The string representation of each parameter is obtained, often by calling String.valueOf( ). The result is appended to the current StringBuffer object. The buffer itself is returned by each version of append( ). This allows subsequent calls to be chained together, as shown in the following example: [StringBuffer append() Demo](https://github.com/zed1025/java-library-notes/blob/master/appendDemo.java)
  - The `insert( )` method inserts one string into another. It is overloaded to accept values of all the primitive types, plus Strings, Objects, and CharSequences. Like append( ), it obtains the string representation of the value it is called with. This string is then inserted into the invoking StringBuffer object. These are a few of its forms:
    - `StringBuffer insert(int index, String str)`
    - `StringBuffer insert(int index, char ch)`
    - `StringBuffer insert(int index, Object obj)`
    - The following sample program inserts "like" between "I" and "Java": [StringBuffer insert() Demo](https://github.com/zed1025/java-library-notes/blob/master/insertDemo.java)
  - You can reverse the characters within a StringBuffer object using reverse( ), shown here: `StringBuffer reverse( )`. [StringBuffer Reverse Demo](https://github.com/zed1025/java-library-notes/blob/master/reverseDemo.java)
  - You can delete characters within a StringBuffer by using the methods delete( ) and deleteCharAt( ). These methods are shown here:
    - `StringBuffer delete(int startIndex, int endIndex)`
    - `StringBuffer deleteCharAt(int loc)`
    - [StringBuffer Delete Demo](https://github.com/zed1025/java-library-notes/blob/master/deleteDemo.java)
  - You can replace one set of characters with another set inside a StringBuffer object by calling replace( ). Its signature is shown here: `StringBuffer replace(int startIndex, int endIndex, String str)`. 
    - The substring being replaced is specified by the indexes startIndex and endIndex. Thus, the substring at startIndex through endIndex–1 is replaced. The replacement string is passed in str.
    - [StringBuffer Replace Demo](https://github.com/zed1025/java-library-notes/blob/master/replaceDemo2.java)
  - You can obtain a portion of a StringBuffer by calling substring( ). It has the following two forms:
    - `String substring(int startIndex)`
    - `String substring(int startIndex, int endIndex)`
- More StringBuilder methods
  - `int indexOf(String str)`: Searches the invoking StringBuffer for the first occurrence of str. Returns the index of the match, or –1 if no match is found.
  - `int indexOf(String str, int startIndex)`: Searches the invoking StringBuffer for the first occurrence of str, beginning at startIndex. Returns the index of the match, or –1 if no match is found.
  - `int lastIndexOf(String str)`: Searches the invoking StringBuffer for the last occurrence of str. Returns the index of the match, or –1 if no match is found.
  - `int lastIndexOf(String str, int startIndex)`: Searches the invoking StringBuffer for the last occurrence of str, beginning at startIndex. Returns the index of the match, or –1 if no match is found.
  - [StringBuffer indexOf Demo](https://github.com/zed1025/java-library-notes/blob/master/indexOfDemo.java)
- **StringBuilder**
  - Introduced by JDK 5, StringBuilder is a relatively recent addition to Java’s string handling capabilities. StringBuilder is similar to StringBuffer except for one important difference: it is not synchronized, which means that it is not thread-safe. The advantage of StringBuilderis faster performance. However, in cases in which a mutable string will be accessed by multiple threads, and no external synchronization is employed, you must use StringBuffer rather than StringBuilder.



https://github.com/zed1025/java-library-notes/blob/master/.java




#### Programs for Standard Library
- [Constructing Strings](https://github.com/zed1025/java-library-notes/blob/master/constructingStrings.java)
- [Byte to String](https://github.com/zed1025/java-library-notes/blob/master/byteToString.java)
- [String Length](https://github.com/zed1025/java-library-notes/blob/master/stringLength.java)
- [toString Demo](https://github.com/zed1025/java-library-notes/blob/master/toStringDemo.java)
- [getCharsDemo](https://github.com/zed1025/java-library-notes/blob/master/getCharsDemo.java)
- [toCharArray Demo](https://github.com/zed1025/java-library-notes/blob/master/toCharArrayDemo.java)
- [Equals and EqualsIgnoreCase Demo](https://github.com/zed1025/java-library-notes/blob/master/equalsDemo.java)
- [Starts/Ends With Demo](https://github.com/zed1025/java-library-notes/blob/master/startsEndsWithDemo.java)
- [equalsNotEqualTo](https://github.com/zed1025/java-library-notes/blob/master/equalsOperatorVsMethod.java)
- [Bubble sort using compareTo](https://github.com/zed1025/java-library-notes/blob/master/bubbleSortOfStrings.java)
- [Searching Strings](https://github.com/zed1025/java-library-notes/blob/master/indexOfMethod.java)
- [Substring Demo](https://github.com/zed1025/java-library-notes/blob/master/substringDemo.java)
- [Replace Demo](https://github.com/zed1025/java-library-notes/blob/master/replaceDemo.java)
- [Trim Demo](https://github.com/zed1025/java-library-notes/blob/master/trimDemo.java)
- [Case Changing](https://github.com/zed1025/java-library-notes/blob/master/changeCases.java)
- [Join Demo](https://github.com/zed1025/java-library-notes/blob/master/joinDemo.java)
- [StringBuffer length vs. capacity](https://github.com/zed1025/java-library-notes/blob/master/lengthVsCapacity.java)
- [StringBuffer Ensuring Capacity](https://github.com/zed1025/java-library-notes/blob/master/ensureCap.java)
- [StringBuffer Using Character At](https://github.com/zed1025/java-library-notes/blob/master/setCharAtDemo.java)
- [StringBuffer append Demo](https://github.com/zed1025/java-library-notes/blob/master/appendDemo.java)
- [StringBuffer insert Demo](https://github.com/zed1025/java-library-notes/blob/master/insertDemo.java)
- [StringBuffer Reverse Demo](https://github.com/zed1025/java-library-notes/blob/master/reverseDemo.java)
- [StringBuffer Delete Demo](https://github.com/zed1025/java-library-notes/blob/master/deleteDemo.java)
- [StringBuffer Replace Demo](https://github.com/zed1025/java-library-notes/blob/master/replaceDemo2.java)
- [StringBuffer indexOf Demo](https://github.com/zed1025/java-library-notes/blob/master/indexOfDemo.java)





