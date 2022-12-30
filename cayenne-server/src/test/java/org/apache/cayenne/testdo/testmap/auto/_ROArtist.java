package org.apache.cayenne.testdo.testmap.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.List;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.property.DateProperty;
import org.apache.cayenne.exp.property.ListProperty;
import org.apache.cayenne.exp.property.NumericIdProperty;
import org.apache.cayenne.exp.property.PropertyFactory;
import org.apache.cayenne.exp.property.SelfProperty;
import org.apache.cayenne.exp.property.StringProperty;
import org.apache.cayenne.testdo.testmap.Painting;
import org.apache.cayenne.testdo.testmap.ROArtist;

/**
 * Class _ROArtist was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _ROArtist extends BaseDataObject {

    private static final long serialVersionUID = 1L;

    public static final SelfProperty<ROArtist> SELF = PropertyFactory.createSelf(ROArtist.class);

    public static final NumericIdProperty<Long> ARTIST_ID_PK_PROPERTY = PropertyFactory.createNumericId("ARTIST_ID", "ROArtist", Long.class);
    public static final String ARTIST_ID_PK_COLUMN = "ARTIST_ID";

    public static final StringProperty<String> ARTIST_NAME = PropertyFactory.createString("artistName", String.class);
    public static final DateProperty<Date> DATE_OF_BIRTH = PropertyFactory.createDate("dateOfBirth", Date.class);
    public static final ListProperty<Painting> PAINTING_ARRAY = PropertyFactory.createList("paintingArray", Painting.class);

    protected String artistName;
    protected Date dateOfBirth;

    protected Object paintingArray;

    public String getArtistName() {
        beforePropertyRead("artistName");
        return this.artistName;
    }

    public Date getDateOfBirth() {
        beforePropertyRead("dateOfBirth");
        return this.dateOfBirth;
    }

    @SuppressWarnings("unchecked")
    public List<Painting> getPaintingArray() {
        return (List<Painting>)readProperty("paintingArray");
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "artistName":
                return this.artistName;
            case "dateOfBirth":
                return this.dateOfBirth;
            case "paintingArray":
                return this.paintingArray;
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
            case "artistName":
                this.artistName = (String)val;
                break;
            case "dateOfBirth":
                this.dateOfBirth = (Date)val;
                break;
            case "paintingArray":
                this.paintingArray = val;
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
        out.writeObject(this.artistName);
        out.writeObject(this.dateOfBirth);
        out.writeObject(this.paintingArray);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.artistName = (String)in.readObject();
        this.dateOfBirth = (Date)in.readObject();
        this.paintingArray = in.readObject();
    }

}
