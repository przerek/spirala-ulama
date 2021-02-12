package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Razem {

    static int black = new Color(0, 0, 0).getRGB();
    static int white = new Color(255, 255, 255).getRGB();


    public static String zmienKierunek(String kierunek) {
        String out = "";
        switch (kierunek) {
            case "lewo":
                out = "gora";
                break;

            case "prawo":
                out = "dol";
                break;

            case "gora":
                out = "prawo";
                break;

            case "dol":
                out = "lewo";
                break;
        }
        return out;
    }

    static int zwrocPozycje(int rozmiar){
        int a;
        if (rozmiar % 2 == 0)
            a = (rozmiar / 2) - 1;
         else
            a = rozmiar / 2;
        return a;
    }

    public static void main(String args[]) throws IOException {


        int x,y;
        int rozmiar = 100;
        x=zwrocPozycje(rozmiar);
        y=zwrocPozycje(rozmiar);

        int ilosc = rozmiar * rozmiar;


        BufferedImage image = new BufferedImage(rozmiar, rozmiar, BufferedImage.TYPE_INT_RGB);

        int max = 1;
        int licznik = 0;
        int powtorzenie = 0;
        String kierunek = "prawo";

        boolean[] prime = new boolean[ilosc + 1];
        for (int i = 0; i < ilosc; i++)
            prime[i] = true;

        for (int p = 2; p * p <= ilosc; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= ilosc; i += p)
                    prime[i] = false;
            }
        }

        // Print all prime numbers
        for (int i = 1; i <= ilosc; i++) {

            System.out.println(i + " z " + ilosc);

            if (prime[i])
                image.setRGB(x, y, white);
             else
                image.setRGB(x, y, black);


            if (licznik == max) {
                powtorzenie++;
                kierunek = zmienKierunek(kierunek);
                licznik = 0;
                if (powtorzenie == 2) {
                    powtorzenie = 0;
                    max++;
                }
            }

            licznik++;
            switch (kierunek) {
                case "lewo":
                    x--;
                    break;

                case "prawo":
                    x++;
                    break;

                case "gora":
                    y--;
                    break;

                case "dol":
                    y++;
                    break;
            }
        }

        File outputfile = new File("saved.png");
        ImageIO.write(image, "png", outputfile);

    }
}