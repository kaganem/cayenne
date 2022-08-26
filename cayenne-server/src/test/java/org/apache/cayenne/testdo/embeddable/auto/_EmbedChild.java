package org.apache.cayenne.testdo.embeddable.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.cayenne.exp.property.EntityProperty;
import org.apache.cayenne.exp.property.PropertyFactory;
import org.apache.cayenne.exp.property.StringProperty;
import org.apache.cayenne.testdo.embeddable.EmbedChild;
import org.apache.cayenne.testdo.embeddable.EmbedRoot;

/**
 * Class _EmbedChild was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _EmbedChild extends EmbedRoot {

    private static final long serialVersionUID = 1L;

    public static final EntityProperty<EmbedChild> SELF = PropertyFactory.createSelf(EmbedChild.class);

    public static final String ID_PK_COLUMN = "ID";

    public static final StringProperty<String> CHILD_ATTR = PropertyFactory.createString("childAttr", String.class);

    protected String childAttr;


    public void setChildAttr(String childAttr) {
        beforePropertyWrite("childAttr", this.childAttr, childAttr);
        this.childAttr = childAttr;
    }

    public String getChildAttr() {
        beforePropertyRead("childAttr");
        return this.childAttr;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "childAttr":
                return this.childAttr;
            default:
                return super.readPropertyDirectly(propName);
        }
    }

    @Override
    public void writePropertyDirectly(String propName, Object val) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch (propName) {
            case "childAttr":
                this.childAttr = (String)val;
                break;
            default:
                super.writePropertyDirectly(propName, val);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        writeSerialized(out);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        readSerialized(in);
    }

    @Override
    protected void writeState(ObjectOutputStream out) throws IOException {
        super.writeState(out);
        out.writeObject(this.childAttr);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.childAttr = (String)in.readObject();
    }

}
