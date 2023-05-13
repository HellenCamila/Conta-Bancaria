import java.util.Scanner; 
import java.io.IOException;    
	
	class Console {

    public static void clear(String... arg) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
     
	
	
    class Bancaria {
	
   static double saldo;

   
	public static void pressioneParaMenu() throws IOException, InterruptedException{  
	
	System.out.print("Pressione enter para voltar ao menu pricipal");
	System.in.read();
	}
    public static boolean validarSangria (double valor) {   
    
    if(valor > saldo){
      return false;
    }
    
    return true;
  }
  
  public static void reforcoSaldo(double valor){
    saldo = saldo + valor;
  }
  public static void sangriaSaldo(double valor){
    saldo = saldo - valor;
  }
    
  public static void depositar() throws IOException, InterruptedException{  
    
      Scanner teclado = new Scanner(System.in);   
      
      double valor;
      
      System.out.print("Insira o valor que  deseja depositar?\n\n");
      
      valor = teclado.nextDouble();
      
      reforcoSaldo(valor);  

      menu();      
      
  }
  
  public static double sacar(double valor) throws IOException, InterruptedException{  
	   Scanner teclado = new Scanner(System.in); 
	   
	 
	  System.out.print("Insira o valor que  deseja retirar?\n\n");
      
      valor = teclado.nextDouble();
      
      if(validarSangria(valor) == false){
		  
        System.out.print("Saldo insuficiente\n\n");
		
		pressioneParaMenu();
	
        menu();
      }
      
     sangriaSaldo(valor);
        
    return saldo;
  } 
  
  public static double exibirSaldo() throws IOException, InterruptedException{  
      
    System.out.print(saldo);
        
    return saldo;
  }
  
  public static void menu() throws IOException, InterruptedException{ 
    Scanner teclado = new Scanner(System.in);   

    int opcao;
    
    System.out.print(" Menu do meu sistema\n\n");
    System.out.print("------------------------\n\n");
    System.out.print(" Por favor selecione uma opção:\n");
    System.out.print("------------------------\n\n");
    System.out.print("[1] - Depositar\n");
    System.out.print("[2] - Sacar\n");
    System.out.print("[3] - Exibir saldo\n");
    System.out.print("[4] - Sair do sistema\n");
    
    opcao = teclado.nextInt();       
    
    switch (opcao) {
      case 1:
      depositar();
      break;

      case 2:
      sacar(10.0);
      menu();
      break;

      case 3:
      exibirSaldo();
      menu();
      break;

      case 4:
      System.exit(0);
      break;

    default:
      System.out.printf("Insira uma opção válida ");
    
    }
  }
  
	public static void main(String args[])throws IOException, InterruptedException{    
	 
    saldo = 0;

    menu();    
       
    System.exit(0);
		
	}

}
