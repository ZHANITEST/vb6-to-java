/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package buggymastercode;

/**
 *
 * @author jalvarez
 */
public class VariableObject {

    private int m_id = 0;
    private int m_cl_id = 0;
    private String m_vbName = "";
    private String m_javaName = "";

    public void setId(int value) {m_id = value;}
    public int getId() {return m_id;}
    public void setClId(int value) {m_cl_id = value;}
    public void setVbName(String value) {m_vbName = value;}
    public void setJavaName(String value) {m_javaName = value;}

    public boolean saveVariable() {
        if (m_id == Db.CS_NO_ID) {

            DataBaseId id = new DataBaseId();

            if (!Db.db.getNewId("tvariable", id)) {
                return false;
            }

            String sqlstmt = "insert into tvariable (cl_id, var_id, var_vbname, var_javaname) values ("
                            + ((Integer)m_cl_id).toString()
                            + ", " + id.getId().toString()
                            + ", " + Db.getString(m_vbName)
                            + ", " + Db.getString(m_javaName)
                            + ")";

            if (Db.db.execute(sqlstmt)) {
                m_id = id.getId();
            }
            else {
                return false;
            }

        }
        else {

            String sqlstmt = "update tvariable set "
                            + "var_vbname = "  + Db.getString(m_vbName)
                            + ", var_javaname = "  + Db.getString(m_javaName)
                            + " where var_id = " + ((Integer)m_id).toString();

            if (!Db.db.execute(sqlstmt)) {
                return false;
            }
        }
        return true;
    }

    public boolean deleteVariable() {
        String sqlstmt = "delete from tvariable where var_id = " + ((Integer)m_id).toString();
        if (Db.db.execute(sqlstmt)) {
            return true;
        }
        else {
            return false;
        }
    }
}