package gfg.trie;

import java.util.Scanner;

class TrieNode {
    TrieNode []child = new TrieNode[26];
    boolean isEnd;

    public TrieNode(){
        this.isEnd = false;
    }
}

class Trie {

    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String input){

        TrieNode current = root;
        for(int i=0;i<input.length();i++){

            if(current.child[input.charAt(i)-'a']!=null){
                current = current.child[input.charAt(i)-'a'];
            }
            else {
                TrieNode newNode = new TrieNode();
                current.child[input.charAt(i)-'a']=newNode;
                current = newNode;
            }
        }

        current.isEnd = true;

    }

    public boolean search(String input){
        TrieNode current = root;
        int pos = 0;
        while(pos!=(input.length())){
            if(current.child[input.charAt(pos)-'a']!=null){
                current = current.child[input.charAt(pos)-'a'];
            }
            else{
                return false;
            }
            pos++;
        }

        if(current.isEnd){
            return true;
        }
        else
            return false;


    }

    private void printDictionary(TrieNode current, String output){

        if(current.isEnd){
            System.out.println(output);

        }
        for(int i=0;i<26;i++){
            if(current.child[i]!=null){
                char val = (char) ('a'+i);
                printDictionary(current.child[i], output+ val);
            }
        }

    }

    public void print(){
        printDictionary(root, "");
    }

    public void delete(String input ){
        deleteWord(root, input, 0);
    }

    public boolean deleteWord(TrieNode current, String input, int pos){

        if(pos==input.length()){
            current.isEnd=false;
            for(int i=0;i<26;i++){
                if(current.child[i]!=null){
                    return false;
                }
            }

            return true;
        }
        else{
            boolean deleteNode = deleteWord(current.child[input.charAt(pos)-'a'], input, pos+1);
            if(deleteNode && !current.isEnd) {
                current.child[input.charAt(pos) - 'a'] = null;
                for(int i=0;i<26;i++){
                    if(current.child[i]!=null){
                        return false;
                    }
                }
                return true;

            }
            else{
                return false;
            }
        }
    }

}

public class TrieImpl {

    public static void main(String []args){

        System.out.println("Trie implementation");
        Scanner sc = new Scanner(System.in);
        int n = 0;
        Trie trie = new Trie();
        while(n!=-1){
            System.out.println("Select the operation");
            System.out.println("1. Print");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Insert");
            System.out.println("5. Exit");

            n = sc.nextInt();
            sc.nextLine();
            switch (n) {
                case 1:
                    trie.print();
                    break;
                case 2:

                    String input = sc.nextLine();
                    boolean found = trie.search(input);
                    if(found){
                        System.out.println("Word found");
                    }
                    else{
                        System.out.println("Word Not found");
                    }
                    break;
                case 3:
                    String inp = sc.nextLine();
                    boolean f = trie.search(inp);
                    if(f){
                        trie.delete(inp);
                    }
                    break;
                case 4:
                    String input1 = sc.nextLine();
                    trie.insert(input1);
                    break;
                case 5:
                    n=-1;
                    break;
            }

        }


    }

}
