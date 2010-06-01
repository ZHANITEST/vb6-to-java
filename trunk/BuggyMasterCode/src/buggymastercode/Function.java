/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package buggymastercode;

/**
 *
 * @author jalvarez
 */
public class Function {

    static private final String newline = "\n";

    private Variable returnType = new Variable();
    public String vbDeclaration = "";
    public String javaDeclaration = "";

    public String getName() {
        return returnType.name;
    }

    public Variable getReturnType() {
        return returnType;
    }

    public String getDeclarations() {
        return vbDeclaration + newline + newline + javaDeclaration;
    }

    @Override
    public String toString() {
        return getName();
    }
}