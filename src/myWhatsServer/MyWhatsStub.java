package myWhatsServer;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MyWhatsStub {

    /**
     * trata dos argumentos introduzidos pelo utilizador para enviar para o servidor
     * @throws IOException
     *
     */

    public static void handle(List<String> lista, ObjectOutputStream out) throws IOException {
        String[] args = (String[]) lista.toArray();
        String msg;

        switch (args[0]) {
            case "-r":
                    // all
                if (args.length==1)
                    msg="-r";
                    // contact
                else if (args.length==2)
                    msg = args[0] + ":" + args[1];
                    // contact file
                else
                    msg = args[0] + ":" + args[1] + ":" + args[2];
                out.writeObject(msg);
                break;
            case "-f":
                Path path = Paths.get(args[2]);
                byte[] data = Files.readAllBytes(path);

                msg = args[0] + ":" + args[1] + ":" + args[2];

                out.writeObject(msg);
                out.writeObject(data);
                break;
            case "-m":
            case "-a":
            case "-d":
                msg = args[0] + args[1] + args[2];
                out.writeObject(msg);
                break;
            default:
                throw new IOException("opcao errada");
        }
    }
}