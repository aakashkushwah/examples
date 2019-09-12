package com.akushwah.dsalgo.stack;


public class Main {
    public static void main(String[] args) {
        Employee aakash = new Employee("Aakash", "Kushwah", 123);
        Employee mary = new Employee("Mary","Smith", 223);
        Employee john = new Employee("John","Millman", 224);
        Employee mike = new Employee("Mike", "Ross", 225);

        ArrayStack<Employee> stack = new ArrayStack<>(3);
        stack.push(aakash);
        System.out.println("Pushed 1");
        stack.push(mary);
        System.out.println("Pushed 2");
        stack.push(john);
        System.out.println("Pushed 3");
        stack.push(mike);
        System.out.println("Pushed 4");

        stack.printStack();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        System.out.println("***********");
        LinkedStack<Employee> linkedStack = new LinkedStack<>();
        linkedStack.push(aakash);
        linkedStack.push(mary);
        linkedStack.push(john);
        linkedStack.push(mike);

        linkedStack.printStack();
        System.out.println(linkedStack.peek());
        linkedStack.pop();
        System.out.println(linkedStack.peek());

        System.out.println("Challenge");
        System.out.println(checkForPalindrome("Don't nod"));

    }

    public static boolean checkForPalindrome(String str){
        LinkedStack<Character> stack = new LinkedStack<>();
        StringBuilder stringNoPunctuation = new StringBuilder(str.length());
        String lower = str.toLowerCase();
        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if(c>='a' && c<='z'){
                stack.push(c);
                stringNoPunctuation.append(c);
            }
        }

        StringBuilder reversed = new StringBuilder(stack.size());
        while(!stack.isEmpty()){
            reversed.append(stack.pop());
        }
        return stringNoPunctuation.toString().equals(reversed.toString());
    }
}
