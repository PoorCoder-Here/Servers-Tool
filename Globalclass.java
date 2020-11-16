package com.vbh.hotel_billing_system;

import android.app.Application;
import java.util.LinkedList;

public class Globalclass extends Application
{
    LinkedList<String> it=new LinkedList<>();
    LinkedList<String> itna=new LinkedList<>();
    LinkedList<String> qua=new LinkedList<>();
    LinkedList<String> pri=new LinkedList<>();

    LinkedList<String> t2it=new LinkedList<>();
    LinkedList<String> t2itna=new LinkedList<>();
    LinkedList<String> t2qua=new LinkedList<>();
    LinkedList<String> t2pri=new LinkedList<>();

    LinkedList<String> t3it=new LinkedList<>();
    LinkedList<String> t3itna=new LinkedList<>();
    LinkedList<String> t3qua=new LinkedList<>();
    LinkedList<String> t3pri=new LinkedList<>();

    LinkedList<String> t4it=new LinkedList<>();
    LinkedList<String> t4itna=new LinkedList<>();
    LinkedList<String> t4qua=new LinkedList<>();
    LinkedList<String> t4pri=new LinkedList<>();

    void itnoset(String ino)
    {
        it.add(ino);
    }
    void itnaset(String ina)
    {
        itna.add(ina);
    }
    void quaset(String qu)
    {
        qua.add(qu);
    }
    void priset(String pr) { pri.add(pr); }

    String itenoget(int pos)
    {
        return (it.get(pos));
    }
    String itenaget(int pos) { return (itna.get(pos)); }
    String quaget(int pos) { return (qua.get(pos)); }
    String priget(int pos) { return (pri.get(pos)); }

    void t2itnoset(String ino)
    {
        t2it.add(ino);
    }
    void t2itnaset(String ina)
    {
        t2itna.add(ina);
    }
    void t2quaset(String qu)
    {
        t2qua.add(qu);
    }
    void t2priset(String pr) { t2pri.add(pr); }

    String t2itenoget(int pos)
    {
        return (t2it.get(pos));
    }
    String t2itenaget(int pos) { return (t2itna.get(pos)); }
    String t2quaget(int pos) { return (t2qua.get(pos)); }
    String t2priget(int pos) { return (t2pri.get(pos)); }

    void t3itnoset(String ino)
    {
        t3it.add(ino);
    }
    void t3itnaset(String ina)
    {
        t3itna.add(ina);
    }
    void t3quaset(String qu)
    {
        t3qua.add(qu);
    }
    void t3priset(String pr) { t3pri.add(pr); }

    String t3itenoget(int pos)
    {
        return (t3it.get(pos));
    }
    String t3itenaget(int pos) { return (t3itna.get(pos)); }
    String t3quaget(int pos) { return (t3qua.get(pos)); }
    String t3priget(int pos) { return (t3pri.get(pos)); }

    void t4itnoset(String ino)
    {
        t4it.add(ino);
    }
    void t4itnaset(String ina)
    {
        t4itna.add(ina);
    }
    void t4quaset(String qu)
    {
        t4qua.add(qu);
    }
    void t4priset(String pr) { t4pri.add(pr); }

    String t4itenoget(int pos)
    {
        return (t4it.get(pos));
    }
    String t4itenaget(int pos) { return (t4itna.get(pos)); }
    String t4quaget(int pos) { return (t4qua.get(pos)); }
    String t4priget(int pos) { return (t4pri.get(pos)); }

    void edit(String i)
    {
        int pos=t4it.indexOf(i);
        t4it.remove(pos);
        t4itna.remove(pos);
        t4pri.remove(pos);
        t4qua.remove(pos);
    }
    void edit1(String i)
    {
        int pos=it.indexOf(i);
        it.remove(pos);
        itna.remove(pos);
        pri.remove(pos);
        qua.remove(pos);
    }
    void edit2(String i)
    {
        int pos=t2it.indexOf(i);
        t2it.remove(pos);
        t2itna.remove(pos);
        t2pri.remove(pos);
        t2qua.remove(pos);
    }
    void edit3(String i)
    {
        int pos=t3it.indexOf(i);
        t3it.remove(pos);
        t3itna.remove(pos);
        t3pri.remove(pos);
        t3qua.remove(pos);
    }
}
