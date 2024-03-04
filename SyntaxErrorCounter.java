package MCALab;

import javax.tools.*;
import java.io.IOException;

public class SyntaxErrorCounter {
    public static void main(String[] args) {
        if(args.length!=1){
            System.out.println("Use : java CountSyntaxError fileName.java");
        } else {
            String fileName=args[0];
            long syntaxErrorCount=countSyntaxErrors(fileName);
            System.out.println("Number of syntax errors : " +syntaxErrorCount);
        }
    }
    public static long countSyntaxErrors(String fileName){
        long syntaxErrorCount=0;
        JavaCompiler compiler= ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics=new DiagnosticCollector<>();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics,null,null);
        Iterable<? extends JavaFileObject> compilationUnits=fileManager.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask task= compiler.getTask(null,fileManager,diagnostics,null,null,compilationUnits);
        boolean success= task.call();
        if(!success){
            for(Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()){
                if(diagnostic.getKind()==Diagnostic.Kind.ERROR){
                    syntaxErrorCount++;
                }
            }
        }
        try{
            fileManager.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return syntaxErrorCount;
    }
}
