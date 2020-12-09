package com.adobe.aem.guides.rumi.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.wcm.core.components.models.ListItem;
import com.adobe.cq.wcm.core.components.models.Teaser;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.via.ResourceSuperType;

import javax.inject.Inject;
import java.util.List;
/**
 * Model for Hero CTA Component.
 */
@Model(adaptables = { Resource.class, SlingHttpServletRequest.class }, adapters = {
        Teaser.class, HeroCtaModel.class, ComponentExporter.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = "rumi/components/content/teaser")
@Exporter(name = "jackson", extensions = "json")
public class HeroCtaModel implements Teaser, ComponentExporter {
    /**
     * text.
     */
    @ScriptVariable
    private Page currentPage;
    @Self
    @Via(type = ResourceSuperType.class)
    private Teaser teaser;

    @Inject
    private Resource resource;

    @Self
    private SlingHttpServletRequest request;
    /**
     * title.
     */
    @ValueMapValue
    @Default(values = "Hero CTA")
    private String subtitle;

    public String getSubtitle() {
        return subtitle;
    }

    @Override
    public String getTitle() {
        return teaser.getTitle();
    }

    @Override
    public String getTitleType() {
        return teaser.getTitleType();
    }

    @Override
    public List<ListItem> getActions() {
        return teaser.getActions();
    }

    @Override
    public String getExportedType() {
        return teaser.getExportedType();
    }

    @Override
    public Resource getImageResource() {
        return teaser.getImageResource();

    }

    @Override
    public String getLinkURL() {
        return teaser.getLinkURL();
    }

    @Override
    public boolean isActionsEnabled() {
        return teaser.isActionsEnabled();
    }

    @Override
    public boolean isImageLinkHidden() {
        return teaser.isImageLinkHidden();
    }

    @Override
    public boolean isTitleLinkHidden() {
        return teaser.isTitleLinkHidden();
    }

}

