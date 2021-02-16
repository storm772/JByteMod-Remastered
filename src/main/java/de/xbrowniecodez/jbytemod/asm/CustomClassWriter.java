package de.xbrowniecodez.jbytemod.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.ModuleVisitor;
import org.objectweb.asm.ModuleWriter;

public class CustomClassWriter extends ClassWriter {

    public CustomClassWriter(int flags) {
        super(flags);
        // TODO Auto-generated constructor stub
    }

    @Override
    public final ModuleVisitor visitModule(final String name, final int access, final String version) {
        try {
            return moduleWriter = new ModuleWriter(symbolTable, symbolTable.addConstantModule(name).index, access,
                    version == null ? 0 : symbolTable.addConstantUtf8(version));
        } catch (NullPointerException npe) {
            return moduleWriter = new ModuleWriter(symbolTable, 0, 0 ,0);
        }
        
    }

}
