package com.igor.entities;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;

//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@MappedSuperclass
@DiscriminatorColumn
public abstract class ImagedEntity extends AbstractEntity {
    @Column(name = "img")
    @Lob
    private Byte[] image;

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public void setImage(MultipartFile file) throws IOException {
        Byte[] byteObjects = new Byte[file.getBytes().length];

        int i = 0;

        for (byte b : file.getBytes()) {
            byteObjects[i++] = b;
        }

        this.setImage(byteObjects);
    }
}
