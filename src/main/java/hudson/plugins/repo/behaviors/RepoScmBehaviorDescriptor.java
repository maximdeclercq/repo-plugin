/*
 * The MIT License
 *
 * Copyright (c) 2010, Brad Larson
 * Copyright (c) 2019, CloudBees Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package hudson.plugins.repo.behaviors;

import hudson.Extension;
import hudson.ExtensionComponent;
import hudson.ExtensionList;
import hudson.model.Descriptor;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;

import java.util.Comparator;
import java.util.List;

/**
 * Base descriptor for all {@link RepoScmBehavior}s.
 *
 * @param <T> the type
 */
public abstract class RepoScmBehaviorDescriptor<T extends RepoScmBehavior<T>> extends Descriptor<T> {

    /**
     * {@link Comparator} sorting the extensions by their {@link Extension#ordinal()}.
     */
    @Restricted(NoExternalUse.class) //CS IGNORE JavaDoc FOR NEXT 4 LINES. REASON: Checkstyle is drunk
    public static final Comparator<RepoScmBehavior<?>> EXTENSION_COMPARATOR = (b1, b2) -> {
        ExtensionComponent<RepoScmBehavior<?>> e1 = new ExtensionComponent<>(b1,
                b1.getDescriptor().getClass().getAnnotation(Extension.class));
        ExtensionComponent<RepoScmBehavior<?>> e2 = new ExtensionComponent<>(b2,
                b2.getDescriptor().getClass().getAnnotation(Extension.class));
        return e1.compareTo(e2);
    };

    /**
     * Lists all extensions of this class.
     *
     * @return the descriptors
     */
    public static List<RepoScmBehaviorDescriptor> all() {
        return ExtensionList.lookup(RepoScmBehaviorDescriptor.class);
    }
}
