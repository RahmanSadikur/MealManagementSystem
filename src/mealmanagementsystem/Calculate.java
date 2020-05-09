/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mealmanagementsystem;


public class Calculate {
    private double totalmeal;
    private double totalexpense;
    private double mealrate;
    private double personalmeal;
    private double personaldebit;
    private double credit;
    private double remain;
    
    public Calculate(){}
    public void gettotalmeal(String m)
    {
        totalmeal=Double.parseDouble(m);
        System.out.println("total meal:"+totalmeal);
        //String test=String.valueOf(totalmeal);
        //System.out.println("total meal:"+totalmeal);
        
        
    }
    public void gepersonalmeal(String m)
    {
        personalmeal=Double.parseDouble(m);
        
    }
    public void gettotalexpense(String m)
    {
        totalexpense=Double.parseDouble(m);
      
    }
    public void getpesonaldebit(String d)
    {
        
        personaldebit=Double.parseDouble(d);
      
    }
    public String calcadit()
    {
        String cr;
        
        credit=Math.round(personalmeal*mealrate);
        cr=String.valueOf(credit);
        
        return cr;
    }
    public String calmealrate()
    {
        String mr;
        mealrate=Math.round(totalexpense/totalmeal);
        mr=String.valueOf(mealrate);
        return mr;
        
    }
    public String calremain()
    {
        String re;
        remain=Math.round(personaldebit-credit);
        re=String.valueOf(remain);
        return re;
    }
}
