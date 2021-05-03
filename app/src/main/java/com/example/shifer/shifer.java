package com.example.shifer;

public class shifer {
    public char[] chezarkod(String a, int rot) {
        int rot2 = rot;
        char[] b = a.toCharArray();
        for (int i = 0; i < b.length; i++) {
            if (b[i] == ' ') {
                while (b[i + 1] == ' ') {
                    i++;
                }
                i++;
            }
            if (((b[i] + rot) <= 'я') && (b[i] + rot) >= 'а') {
                b[i] = (char) (b[i] + rot);
            } else {
                for (; rot2 != 0; ) {
                    if (b[i] == 'я') {
                        b[i] = 'а';
                        rot2--;
                    } else {
                        b[i] = (char) (b[i] + 1);
                        rot2--;
                    }
                }

            }
            rot2 = rot;

        }

        return b;


    }


    public char[] chezardekod(String a , int rot){
        int rot2 = rot;
        char[] b = a.toCharArray();
        for(int i =0;i<b.length;i++){
            if(b[i]==' '){
                while(b[i+1]==' '){
                    i++;
                }
                i++;
            }
            if(((b[i]-rot)<='я')&&(b[i]-rot)>='а'){
                b[i]= (char) (b[i]-rot);
            }
            else {
                for(;rot2!=0;){
                    if(b[i]=='а'){
                        b[i]= 'я';
                        rot2--;
                    }
                    else {
                        b[i]= (char) (b[i]-1);
                        rot2--;
                    }
                }

            }
            rot2=rot;

        }

        return b;


    }
        public char[] vhisnerkod(String a,String rotr) {
        char[] roters = rotr.toCharArray();
        int chet=0;
        int[] rot = new int[rotr.length()];
        int[] rot2 = new int[rotr.length()];
        for(int ii=0;ii<rotr.length();ii++){
            rot[ii] =  roters[ii] - 1071;
            rot2[ii]=   rot[ii];
        }
        char[] b = a.toCharArray();
        for (int i = 0; i < b.length; i++) {
            if (b[i] == ' ') {
                while (b[i + 1] == ' ') {
                    i++;
                }
                i++;
            }
            if (((b[i] + rot[chet]) <= 'я') && (b[i] + rot[chet]) >= 'а') {
                b[i] = (char) (b[i] + rot[chet]);
            } else {
                for (; rot2[chet] != 0; ) {
                    if (b[i] == 'я') {
                        b[i] = 'а';
                        rot2[chet]--;
                    } else {
                        b[i] = (char) (b[i] + 1);
                        rot2[chet]--;
                    }
                }

            }
            rot2[chet] = rot[chet];
            if(chet==roters.length-1){
                chet=-1;
            }
            chet++;
        }

        return b;


    }
    public char[] vhisnerdekod(String a,String rotr) {
        char[] roters = rotr.toCharArray();
        int chet=0;
        int[] rot = new int[rotr.length()];
        int[] rot2 = new int[rotr.length()];
        for(int ii=0;ii<rotr.length();ii++){
            rot[ii] = roters[ii] - 1071;
            rot2[ii]= rot[ii];
        }
        char[] b = a.toCharArray();
        for (int i = 0; i < b.length; i++) {
            if (b[i] == ' ') {
                while (b[i + 1] == ' ') {
                    i++;
                }
                i++;
            }
            if (((b[i] - rot[chet]) <= 'я') && (b[i] - rot[chet]) >= 'а') {
                b[i] = (char) (b[i] - rot[chet]);
            } else {
                for (; rot2[chet] != 0; ) {
                    if (b[i] == 'а') {
                        b[i] = 'я';
                        rot2[chet]--;
                    } else {
                        b[i] = (char) (b[i] - 1);
                        rot2[chet]--;
                    }
                }
                rot2[chet] = rot[chet];
            }
            if(chet==roters.length-1){
                chet=-1;
            }
            chet++;
        }

        return b;


    }
}
