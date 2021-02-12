package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Razem {


    static boolean checkForPrime(int inputNumber) {
        boolean isItPrime = true;

        if (inputNumber <= 1) {
            isItPrime = false;

            return isItPrime;
        } else {
            for (int i = 2; i <= inputNumber / 2; i++) {
                if ((inputNumber % i) == 0) {
                    isItPrime = false;
                    break;
                }
            }

            return isItPrime;
        }
    }

    static int black = new Color(0, 0, 0).getRGB();
    static int white = new Color(255, 255, 255).getRGB();
    static int green = new Color(0, 255, 0).getRGB();

    public static void pomaluj(int x, int y, int i, BufferedImage image) {
        if (checkForPrime(i))
            image.setRGB(x, y, white);
        else
            image.setRGB(x, y, black);

    }

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









        void sieveOfEratosthenes(int n)
        {

        }

        // Driver Program to test above function
        public static void main(String args[]) throws IOException {



            int x, y;
            int rozmiar = 10000;
            if (rozmiar % 2 == 0) {
                x = (rozmiar / 2) - 1;
                y = (rozmiar / 2) - 1;
            } else {
                x = rozmiar / 2;
                y = rozmiar / 2;
            }
            int ilosc = rozmiar * rozmiar;



            BufferedImage image = new BufferedImage(rozmiar, rozmiar, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < rozmiar; i++)
                for (int j = 0; j < rozmiar; j++)
                    image.setRGB(i, j, green);


            int max = 1;
            int licznik = 0;
            int powtorzenie = 0;
            String kierunek = "prawo";


            /////tu











            System.out.print("Following are the prime numbers ");
            System.out.println("smaller than or equal to " + ilosc);







            // Create a boolean array "prime[0..n]" and initialize
            // all entries it as true. A value in prime[i] will
            // finally be false if i is Not a prime, else true.
            boolean prime[] = new boolean[ilosc+1];
            for(int i=0;i<ilosc;i++)
                prime[i] = true;

            for(int p = 2; p*p <=ilosc; p++)
            {
                // If prime[p] is not changed, then it is a prime
                if(prime[p] == true)
                {
                    // Update all multiples of p
                    for(int i = p*p; i <= ilosc; i += p)
                        prime[i] = false;
                }
            }

            // Print all prime numbers
            for(int i = 1; i <= ilosc; i++)
            {
         /////////////////////////

                    System.out.println(i + " z " + ilosc);


                if(prime[i] == true){
                        image.setRGB(x, y, white);
                    }
                    else{
                        image.setRGB(x, y, black);
                    }

                    if (licznik == max) {
                        powtorzenie++;
                        kierunek = zmienKierunek(kierunek); //
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


                    //////////////////////////////////////////////////////
            }





            File outputfile = new File("saved.png");
            ImageIO.write(image, "png", outputfile);

        }















}
