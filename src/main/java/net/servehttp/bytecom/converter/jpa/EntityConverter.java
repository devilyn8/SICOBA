package net.servehttp.bytecom.converter.jpa;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import net.servehttp.bytecom.persistence.entity.cadastro.EntityGeneric;

 
@FacesConverter(value = "entityConverter", forClass = EntityGeneric.class)
public class EntityConverter implements Converter {
 
    public Object getAsObject(FacesContext ctx, UIComponent component,
            String value) {
        if (value != null) {
            return this.getAttributesFrom(component).get(value);
        }
        return null;
    }
 
    public String getAsString(FacesContext ctx, UIComponent component,
            Object value) {
 
        if (value != null && ! "".equals(value)) {
          EntityGeneric entity = (EntityGeneric) value;
 
            if (entity.getId() != 0) {
                this.addAttribute(component, entity);
 
                if (entity.getId() != 0) {
                    return String.valueOf(entity.getId());
                }
                return (String) value;
            }
        }
        return "";
    }
 
    private void addAttribute(UIComponent component, EntityGeneric o) {
        this.getAttributesFrom(component).put(Integer.toString(o.getId()), o);
    }
 
    private Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }
 
}