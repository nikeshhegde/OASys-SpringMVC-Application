package com.project.erp.pdfgen;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Element;
import org.xhtmlrenderer.extend.FSImage;
import org.xhtmlrenderer.extend.ReplacedElement;
import org.xhtmlrenderer.extend.ReplacedElementFactory;
import org.xhtmlrenderer.extend.UserAgentCallback;
import org.xhtmlrenderer.layout.LayoutContext;
import org.xhtmlrenderer.pdf.ITextFSImage;
import org.xhtmlrenderer.pdf.ITextImageElement;
import org.xhtmlrenderer.render.BlockBox;
import org.xhtmlrenderer.simple.extend.FormSubmissionListener;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Image;

public class PictureRenderer implements ReplacedElementFactory {  

	private final ReplacedElementFactory superFactory;

	public PictureRenderer(ReplacedElementFactory superFactory) {
		this.superFactory = superFactory;
	}

	public ReplacedElement createReplacedElement(LayoutContext c, BlockBox box,
			UserAgentCallback uac, int cssWidth, int cssHeight) {
		Element element = box.getElement();
        if (element == null) {
            return null;
        }

        String nodeName = element.getNodeName();
        String className = element.getAttribute("class");
        if ("div".equals(nodeName) && className.contains("image")) {  /*Use only div tags, no img tags, and keep a class name to div that includes the word "image"*/
            InputStream input = null;
            try {
                input = new FileInputStream(new File("resources/mytheme/login/image/logo2.png"));  /* use location url */
                byte[] bytes = IOUtils.toByteArray(input);
                Image image = Image.getInstance(bytes);
                FSImage fsImage = new ITextFSImage(image);

                if (fsImage != null) {
                    if ((cssWidth != -1) || (cssHeight != -1)) {
                        fsImage.scale(cssWidth, cssHeight);
                    }
                    return new ITextImageElement(fsImage);
                }
            } catch (IOException e) {
                
            } catch (BadElementException e) {
                
            } finally {
                IOUtils.closeQuietly(input);
            }
        }

        return superFactory.createReplacedElement(c, box, uac, cssWidth, cssHeight);
	}

	public void reset() {
		superFactory.reset();

	}

	public void remove(Element e) {
		superFactory.remove(e);

	}

	public void setFormSubmissionListener(FormSubmissionListener listener) {
	 superFactory.setFormSubmissionListener(listener);

	}

}
