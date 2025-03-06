package com.jatin.ds.heap.disjointset;

import java.util.ArrayList;
import java.util.List;

public class DisJointSet {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisJointSet(int n){
        for(int i=0 ; i<=n ; i++){
            size.add(0);
        }

        for(int i=0 ; i<=n ; i++){
            parent.add(i);
        }
    }

    public int findParent(int node){
        if(parent.get(node)==node){
            return node;
        }
        int ultimateParenttNode = findParent(parent.get(node));
        parent.set(node,ultimateParenttNode);
        return ultimateParenttNode;
    }

    public void unionBySize(int u , int v){
        int uUP = findParent(u);
        int uVP = findParent(v);

        if(uUP  == uVP){
            return;
        }

        if(size.get(uUP)>size.get(uVP)){
            size.set(uUP,size.get(uUP)+size.get(uVP));
            parent.set(uVP,uUP);
        }

        else{
            size.set(uVP,size.get(uUP)+size.get(uVP));
            parent.set(uUP,uVP);
        }
    }

    public static void main(String[] args) {
        DisJointSet ds = new DisJointSet(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);
        ds.unionBySize(3, 7);
        if (ds.findParent(7) == ds.findParent(1)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

    }

}
