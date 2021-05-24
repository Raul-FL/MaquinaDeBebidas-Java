package TestesMaquinaBebidas;

import interfaceComUsuario.*;
import org.junit.Assert;
import org.junit.Test;

public class DisplayJUnitTest {
    
    public DisplayJUnitTest() {
    }
    
 @Test
  public void displayCaracterLimite(){
    Display tela = new Display();
   String mensagem ="1234567890123456789012345";
     Assert.assertEquals(25,tela.mostrarMensagem(mensagem).getText().length());
     
  }
  @Test
  public void displayCaracterLimiteMaisUm(){
       Display tela = new Display();
   String mensagem ="12345678901234567890123456";
     Assert.assertEquals(25,tela.mostrarMensagem(mensagem).getText().length());
      
  }
  @Test
  public void displayCaracterLimiteMaisDois(){
       Display tela = new Display();
   String mensagem ="1234567890123456789012345678";
     Assert.assertEquals(25,tela.mostrarMensagem(mensagem).getText().length());
      
  }
  @Test
  public void displayCaracterVazio(){
       Display tela = new Display();
   String mensagem ="";
     Assert.assertEquals("",tela.mostrarMensagem(mensagem).getText());
      
  }
 @Test
  public void displayCaracterEspaco(){
       Display tela = new Display();
   String mensagem =" ";
     Assert.assertEquals(" ",tela.mostrarMensagem(mensagem).getText());
      
  }
  @Test
  public void displayCaracteres(){
       Display tela = new Display();
   String mensagem ="ABCDEFGHIJKLMNOPQRSTUVXZWY";
     Assert.assertEquals("ABCDEFGHIJKLMNOPQRSTUVXZWY",tela.mostrarMensagem(mensagem).getText());
      
  }
  @Test(expected = NullPointerException.class)
  public void displayNull(){
       Display tela = new Display();
   String mensagem =null;
     Assert.assertEquals(null,tela.mostrarMensagem(mensagem).getText());
      
  }
  
}
