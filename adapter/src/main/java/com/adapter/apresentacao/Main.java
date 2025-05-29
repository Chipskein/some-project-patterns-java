package com.adapter.apresentacao;

import com.adapter.negocio.legado.EnviarSMSLegado;
import com.adapter.negocio.legado.SMS;
import com.adapter.negocio.nova.NovaSMS;
import com.adapter.negocio.nova.SMSSenderAdapter;

public class Main {
    public static void main(String[] args) {
        String textoExemplo="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam ac consectetur nunc. Sed molestie at nisi sit amet pretium. Quisque neque mauris, varius ut nunc condimentum, consectetur finibus massa. Etiam vehicula posuere leo a volutpat. Praesent sodales aliquam euismod. Nullam vulputate ligula vel ante ultrices facilisis. Ut at feugiat nisl.\nNulla sed maximus tortor. Donec porttitor porta fringilla. Morbi id efficitur ipsum, commodo gravida nunc. Vestibulum pulvinar justo mollis erat maximus, non mattis sem blandit. Aenean at egestas orci. Fusce nibh mauris, mattis ut augue eget, egestas pellentesque nunc. Phasellus vitae tincidunt purus. Sed id arcu quam. Pellentesque nunc risus, varius porttitor mattis sit amet, tempor a urna. Maecenas scelerisque hendrerit nulla. Etiam malesuada consectetur consequat.\nAliquam sit amet sodales augue. Etiam ac nulla vel eros consequat pretium. Maecenas venenatis elementum egestas. Aliquam auctor mi eleifend, tincidunt purus at, placerat tortor. Duis ipsum dui, tincidunt gravida risus et, sodales feugiat massa. Integer commodo, ante et vulputate mollis, augue enim tempor diam, at hendrerit urna tortor eu arcu. Nulla euismod mi lorem. Suspendisse orci neque, congue quis tortor quis, auctor mattis leo.\nVivamus aliquam sed ante eu molestie. Morbi sagittis elit sit amet tincidunt tempus. Pellentesque maximus tincidunt dignissim. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vestibulum auctor risus sit amet diam sollicitudin, a feugiat orci pretium. Nulla vitae ultrices justo. Vestibulum et rutrum nisl. Etiam et orci laoreet, rhoncus nisi et, aliquam ligula. Curabitur neque neque, dignissim sed mollis vitae, interdum non odio.\nVivamus dapibus sem vel ante pretium tempor. Maecenas pellentesque interdum nibh, id pharetra nisl tincidunt sed. Proin finibus massa dui, quis placerat mi lobortis ac. Donec eu hendrerit quam. Nunc viverra quam sit amet lorem porttitor, vel laoreet nisi fringilla. Fusce ac ante euismod orci interdum fringilla a ut odio. Nunc auctor libero sed fringilla fringilla. Maecenas ex velit, vehicula consectetur feugiat cursus, elementum quis leo. Praesent sed sapien blandit, laoreet libero at, vestibulum velit. Suspendisse potenti. Nam dapibus, urna at ornare molestie, sem velit condimentum est, ac pharetra ligula ante at est. In eu lacus consequat, iaculis justo et, congue mi. Pellentesque hendrerit quam a metus semper venenatis.";
        SMS teste1=new SMS("+16663000", "53940214012",textoExemplo);
        System.out.println("Testando Sistema Legado");
        EnviarSMSLegado legado=new EnviarSMSLegado();
        System.out.println("Legado response: " + legado.sendSMS(teste1));
        
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Testando Sistema Nova");
        SMS teste2=new SMS("+16663000", "53940214012",textoExemplo);
        NovaSMS nova = new NovaSMS();
        SMSSenderAdapter adapter = new SMSSenderAdapter(nova);
        System.out.println("Legado response: " + adapter.sendSMS(teste2));
    }
}