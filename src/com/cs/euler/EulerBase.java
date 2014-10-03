package com.cs.euler;


public abstract class EulerBase {
  public abstract void resolve();

  public void print(Object... objects) {
    System.out.print(String.format("%-30s: ", this.getClass().getSimpleName()));
    if(objects!=null){
      for(Object obj:objects){
        System.out.print(obj);
        System.out.print(" ");
      }
      System.out.println();
    }
  }
}
