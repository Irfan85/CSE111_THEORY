package Assignment05;

public class MyString {
    public char[] c;

    public MyString() {
        c = new char[0];
    }

    public MyString(char[] c) {
        this.c = c;
    }

    public MyString(String s) {
        c = s.toCharArray();
    }

    public int length() {
        return c.length;

    }

    public char charAt(int n) {
        if (n < length() && n >= 0) {
            return c[n];
        } else {
            System.out.print("Invalid index");
            return ' ';
        }
    }

    public boolean startsWith(MyString prefix) {
        if (prefix != null) {
            for (int i = 0; i < prefix.length(); i++) {
                if (prefix.charAt(i) != this.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean endsWith(MyString suffix) {
        if (suffix != null) {
            int j = this.length() - 1;
            for (int i = suffix.length() - 1; i >= 0; i--) {
                if (suffix.charAt(i) != this.charAt(j--)) {
                    return false;
                }
            }
        }

        return true;
    }

    public MyString replaceFirst(char a, char b) {
        MyString myString = new MyString(copyArray(c));
        for (int i = 0; i < this.length(); i++) {
            if (myString.c[i] == a) {
                myString.c[i] = b;
                break;
            }
        }

        return myString;
    }

    public MyString replaceAll(char a, char b) {
        MyString myString = new MyString(copyArray(c));
        for (int i = 0; i < this.length(); i++) {
            if (myString.c[i] == a) {
                myString.c[i] = b;
            }
        }

        return myString;
    }

    public MyString replaceLast(char a, char b) {
        MyString myString = new MyString(copyArray(c));

        for (int i = this.length() - 1; i >= 0; i--) {
            if (myString.c[i] == a) {
                myString.c[i] = b;
                break;
            }
        }

        return myString;
    }

    public MyString toLowerCase() {
        MyString myString = new MyString(copyArray(c));
        for (int i = 0; i < myString.length(); i++) {
            if (myString.c[i] >= 65 && myString.c[i] <= 90) {
                myString.c[i] = (char) (c[i] + 32);
            }
        }
        return myString;
    }

    public MyString toUpperCase() {
        MyString myString = new MyString(copyArray(c));
        for (int i = 0; i < myString.length(); i++) {
            if (myString.c[i] >= 97 && myString.c[i] <= 122) {
                myString.c[i] = (char) (c[i] - 32);
            }
        }
        return myString;
    }

    public boolean equals(MyString myString) {
        if (this.length() != myString.length()) {
            return false;
        } else {
            for (int i = 0; i < this.length(); i++) {
                if (this.c[i] != myString.c[i]) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean equalsIgnoreCase(MyString myString) {
        return this.toLowerCase().equals(myString.toLowerCase());
    }

    public boolean contains(char[] chars) {
        if (chars.length > this.length()) {
            return false;
        } else {
            for (int i = 0; i <= this.length() - chars.length; i++) {
                int match = 0;
                for (int j = 0; j < chars.length; j++) {
                    if (chars[j] == this.c[i + j]) {
                        match++;
                    }
                }

                if (match == chars.length) {
                    return true;
                }
            }
        }

        return false;
    }

    public MyString trim() {
        int leadingSpace = 0, trailingSpace = 0, startPos = 0;
        for (int i = 0; i < this.length(); i++) {
            if (this.c[i] == ' ') {
                leadingSpace++;
            } else {
                startPos = i;
                break;
            }
        }

        for (int i = this.length() - 1; i >= 0; i--) {
            if (this.c[i] == ' ') {
                trailingSpace++;
            } else {
                break;
            }
        }

        char[] trimmedArray = new char[this.length() - (leadingSpace + trailingSpace)];
        for (int i = 0; i < trimmedArray.length; i++) {
            trimmedArray[i] = this.c[startPos++];
        }

        return new MyString(trimmedArray);
    }

    public int compareTo(MyString myString) {
        int minLength = this.length();
        if (this.length() > myString.length()) {
            minLength = myString.length();
        }

        for (int i = 0; i < minLength; i++) {
            if (this.c[i] != myString.c[i]) {
                return this.c[i] - myString.c[i];
            }
        }

        return (this.length() - myString.length());
    }

    public int compareToIgnoreCase(MyString myString) {
        return this.toLowerCase().compareTo(myString.toLowerCase());
    }

    public MyString substring(int startIndex) {
        char[] subArray = new char[this.length() - startIndex];

        for (int i = 0; i < subArray.length; i++) {
            subArray[i] = this.c[startIndex++];
        }

        return new MyString(subArray);
    }

    public MyString substring(int startIndex, int endIndex) {
        char[] subArray = new char[endIndex - startIndex];

        for (int i = 0; i < subArray.length; i++) {
            subArray[i] = this.c[startIndex++];
        }

        return new MyString(subArray);
    }

    public int indexOf(char c) {
        for (int i = 0; i < this.length(); i++) {
            if (this.c[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(char c) {
        for (int i = this.length() - 1; i >= 0; i--) {
            if (this.c[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public int indexOf(char c, int formIndex) {
        for (int i = formIndex; i < this.length(); i++) {
            if (this.c[i] == c) {
                return i - formIndex;
            }
        }
        return -1;
    }

    public int lastIndexOf(char c, int fromIndex) {
        for (int i = this.length() - fromIndex; i >= 0; i--) {
            if (this.c[i] == c) {
                return (this.length() - fromIndex - 1) - i;
            }
        }
        return -1;
    }

    public MyString concat(MyString myString) {
        char[] combinedArray = new char[this.length() + myString.length()];
        for (int i = 0; i < this.length(); i++) {
            combinedArray[i] = this.charAt(i);
        }
        for (int i = 0; i < myString.length(); i++) {
            combinedArray[this.length() + i] = myString.charAt(i);
        }

        return new MyString(combinedArray);
    }

    public boolean isEmpty() {
        return (this.length() == 0);
    }

    private char[] copyArray(char[] c) {
        char[] newArray = new char[c.length];
        for (int i = 0; i < c.length; i++) {
            newArray[i] = c[i];
        }
        return newArray;
    }

    public String toString() {
        return new String(c);
    }

}