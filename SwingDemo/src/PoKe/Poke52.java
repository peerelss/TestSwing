package PoKe;

import java.util.ArrayList;

/**
 * Created by kevin on 2017/5/17.
 */
public class Poke52 {
    public Poke52(){}
    public static void main(String[] args){
        ArrayList<Integer> integers=new Poke52().initPoke(4);
        int sum=0;
        for(int i=0;i<integers.size();i++){
            sum=sum+integers.get(i);
        }
        System.out.println(sum);
    }
    //参数i表示1-11的个数，取值范围为0-4
    public  ArrayList<Integer> initPoke(int times){
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=2;i<=13;i++){
            for(int j=0;j<4;j++){
                if(i<=10){
                    result.add(i);
                }else {
                    result.add(10);
                }
            }
        }
        for(int i=0;i<times;i++){
            result.add(1);
        }
        for(int i=result.size();i<52;i++){
            result.add(11);
        }


        return result;
    }
}
