/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.thomasasel.jsf.inspector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.component.visit.VisitCallback;
import javax.faces.component.visit.VisitContext;
import javax.faces.component.visit.VisitResult;

/**
 *
 * @author tasel
 */
class TreeInspectionVisitor implements VisitCallback {
    
    private final TreeInspectionResult result = new TreeInspectionResult();
    
    @Override
    public VisitResult visit(VisitContext context, UIComponent target) {
        
        ComponentType componentType = ComponentType.build(target); 
        
        if (result.getComponents().get(componentType) == null) {
            result.getComponents().put(componentType, new ArrayList<String>());
        }
        
        if (componentType.isComposite()) {
            result.getComposites().get(componentType).add(target.getClientId());
        } else {
            result.getComponents().get(componentType).add(target.getClientId());
        }
        
        return VisitResult.ACCEPT;
        
    }

    public TreeInspectionResult getResult() {
        return result;
    }
    
}
