
import java.io.*;
public class Main {

    public static void main (String[] args){
        // on définit les variables de longueur de notre programme
        int a1=50;
        int a2=50;
        int d4=50;

        boolean phichangé=false;// booléen nous permettant de vérifier si la valeur de phi a été modifié

       System.out.println("Programme de calcul des angles.");
       System.out.println("");

       // on récupère les données voulues
       System.out.print("Veuillez rentrer la position x souhaitée : ");
       double x = Lire.d();
       System.out.print("Veuillez rentrer la position y souhaitée : ");
       double y = Lire.d();
       System.out.print("Veuillez rentrer l'angle phi souhaité (en degré): ");
       double phi = Lire.d();
       System.out.println("");
       System.out.println("__________________________________________________");
       System.out.println("");
       phi = phi*3.14159/180; // on traduit phi en radians pour les fonction cos et sin


           if(Math.sqrt(Math.pow(x,2)+Math.pow(y,2))>a1+a2+d4) // on vérifie que la branche est accessible par la norme
           {
                System.out.println("La branche n'est pas accessible");
           }
       double Xo2 = x-d4*Math.cos(phi); // on définit les variables de la position de O2
       double Yo2 = y+d4*Math.sin(phi);

       //Calcul de theta2
       double c2 = (Math.pow(Xo2,2)+Math.pow(Yo2,2)-Math.pow(a1,2)-Math.pow(a2,2))/(2*a1*a2);
       double s2= Math.sqrt(1-Math.pow(c2,2));
       double theta2 = Math.atan2(s2,c2);
       theta2=theta2*180/3.14159;

       phi=phi*180/3.14159; //on remet phi en degre

            if(Double.isNaN(theta2)) // on avertie l'utilisateur que le phi entré ne permet pas la position et qu'il est changé
            {
                System.out.println("Votre phi a été changé");
                phichangé=true;
            }

           while(Double.isNaN(theta2)||phi>360) // on détermine le nouveau phi
           {

                   phi=phi+1;
                   phi=phi*3.14159/180;
                   Xo2 = x-d4*Math.cos(phi); // on définit les variables de la position de O2
                   Yo2 = y+d4*Math.sin(phi);
                   c2 = (Math.pow(Xo2,2)+Math.pow(Yo2,2)-Math.pow(a1,2)-Math.pow(a2,2))/(2*a1*a2);
                   s2= Math.sqrt(1-Math.pow(c2,2));
                   theta2 = Math.atan2(s2,c2);
                   theta2=theta2*180/3.14159;
                   phi=phi*180/3.14159;

           }

           if(phi>360) // si après avoir faitt un tour aucune valeur de phi ne va alors on renvoie cette position comme non accessible
           {
                   System.out.println("La position ne semble pas accessible");
           }
           else {
                   //Calcul de Theta1
                   double c1 = (Xo2 * (a1 + a2 * c2) + Yo2 * a2 * c2) / (Math.pow(Xo2, 2) + Math.pow(Yo2, 2));
                   double s1 = (Yo2 * (a1 + a2 * c2) - Xo2 * a2 * c2) / (Math.pow(Xo2, 2) + Math.pow(Yo2, 2));
                   double theta1 = Math.atan2(s1, c1);
                   theta1 = theta1 * 180 / 3.14159;

                   //Calcul de Theta3

                   double theta3 = phi - theta1 - theta2;

                   System.out.println("Theta1 vaut : " + theta1);
                   System.out.println("Theta2 vaut : " + theta2);
                   System.out.println("Theta3 vaut : " + theta3);

                   if(phichangé) //si la valeur de phi est changée alors on affiche sa nouvelle valeur
                   {
                       System.out.println("Le nouveau phi vaut : " + phi);
                   }

           }
        System.out.println("__________________________________________________");
    }

}
