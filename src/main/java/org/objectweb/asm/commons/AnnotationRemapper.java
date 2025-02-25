// ASM: a very small and fast Java bytecode manipulation framework
// Copyright (c) 2000-2011 INRIA, France Telecom
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions
// are met:
// 1. Redistributions of source code must retain the above copyright
//    notice, this list of conditions and the following disclaimer.
// 2. Redistributions in binary form must reproduce the above copyright
//    notice, this list of conditions and the following disclaimer in the
//    documentation and/or other materials provided with the distribution.
// 3. Neither the name of the copyright holders nor the names of its
//    contributors may be used to endorse or promote products derived from
//    this software without specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
// AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
// ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
// LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
// CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
// SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
// INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
// CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
// THE POSSIBILITY OF SUCH DAMAGE.

package org.objectweb.asm.commons;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;

/**
 * An {@link AnnotationVisitor} that remaps types with a {@link Remapper}.
 *
 * @author Eugene Kuleshov
 */
public class AnnotationRemapper extends AnnotationVisitor {

  /** The remapper used to remap the types in the visited annotation. */
  protected final Remapper remapper;

  /**
   * Constructs a new {@link AnnotationRemapper}. <i>Subclasses must not use this constructor</i>.
   * Instead, they must use the {@link #AnnotationRemapper(int,AnnotationVisitor,Remapper)} version.
   *
   * @param annotationVisitor the annotation visitor this remapper must deleted to.
   * @param remapper the remapper to use to remap the types in the visited annotation.
   */
  public AnnotationRemapper(final AnnotationVisitor annotationVisitor, final Remapper remapper) {
    this(/* latest api = */ Opcodes.ASM9, annotationVisitor, remapper);
  }

  /**
   * Constructs a new {@link AnnotationRemapper}.
   *
   * @param api the ASM API version supported by this remapper. Must be one of {@link
   *     Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link
   *     Opcodes#ASM6}, {@link Opcodes#ASM7}, {@link
   *     Opcodes#ASM8} or {@link Opcodes#ASM9}.
   * @param annotationVisitor the annotation visitor this remapper must deleted to.
   * @param remapper the remapper to use to remap the types in the visited annotation.
   */
  protected AnnotationRemapper(
      final int api, final AnnotationVisitor annotationVisitor, final Remapper remapper) {
    super(api, annotationVisitor);
    this.remapper = remapper;
  }

  @Override
  public void visit(final String name, final Object value) {
    super.visit(name, remapper.mapValue(value));
  }

  @Override
  public void visitEnum(final String name, final String descriptor, final String value) {
    super.visitEnum(name, remapper.mapDesc(descriptor), value);
  }

  @Override
  public AnnotationVisitor visitAnnotation(final String name, final String descriptor) {
    AnnotationVisitor annotationVisitor = super.visitAnnotation(name, remapper.mapDesc(descriptor));
    if (annotationVisitor == null) {
      return null;
    } else {
      return annotationVisitor == av ? this : createAnnotationRemapper(annotationVisitor);
    }
  }

  @Override
  public AnnotationVisitor visitArray(final String name) {
    AnnotationVisitor annotationVisitor = super.visitArray(name);
    if (annotationVisitor == null) {
      return null;
    } else {
      return annotationVisitor == av ? this : createAnnotationRemapper(annotationVisitor);
    }
  }

  /**
   * Constructs a new remapper for annotations. The default implementation of this method returns a
   * new {@link AnnotationRemapper}.
   *
   * @param annotationVisitor the AnnotationVisitor the remapper must delegate to.
   * @return the newly created remapper.
   */
  protected AnnotationVisitor createAnnotationRemapper(final AnnotationVisitor annotationVisitor) {
    return new AnnotationRemapper(api, annotationVisitor, remapper);
  }
}
