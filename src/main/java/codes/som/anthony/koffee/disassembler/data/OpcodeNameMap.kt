package codes.som.anthony.koffee.disassembler.data

import org.objectweb.asm.Opcodes.*

val opcodeNameMap = mapOf(
        NOP to "nop",
        ACONST_NULL to "aconst_null",
        ICONST_M1 to "iconst_m1",
        ICONST_0 to "iconst_0",
        ICONST_1 to "iconst_1",
        ICONST_2 to "iconst_2",
        ICONST_3 to "iconst_3",
        ICONST_4 to "iconst_4",
        ICONST_5 to "iconst_5",
        LCONST_0 to "lconst_0",
        LCONST_1 to "lconst_1",
        FCONST_0 to "fconst_0",
        FCONST_1 to "fconst_1",
        FCONST_2 to "fconst_2",
        DCONST_0 to "dconst_0",
        DCONST_1 to "dconst_1",
        BIPUSH to "bipush",
        SIPUSH to "sipush",
        LDC to "ldc",
        ILOAD to "iload",
        LLOAD to "lload",
        FLOAD to "fload",
        DLOAD to "dload",
        ALOAD to "aload",
        IALOAD to "iaload",
        LALOAD to "laload",
        FALOAD to "faload",
        DALOAD to "daload",
        AALOAD to "aaload",
        BALOAD to "baload",
        CALOAD to "caload",
        SALOAD to "saload",
        ISTORE to "istore",
        LSTORE to "lstore",
        FSTORE to "fstore",
        DSTORE to "dstore",
        ASTORE to "astore",
        IASTORE to "iastore",
        LASTORE to "lastore",
        FASTORE to "fastore",
        DASTORE to "dastore",
        AASTORE to "aastore",
        BASTORE to "bastore",
        CASTORE to "castore",
        SASTORE to "sastore",
        POP to "pop",
        POP2 to "pop2",
        DUP to "dup",
        DUP_X1 to "dup_x1",
        DUP_X2 to "dup_x2",
        DUP2 to "dup2",
        DUP2_X1 to "dup2_x1",
        DUP2_X2 to "dup2_x2",
        SWAP to "swap",
        IADD to "iadd",
        LADD to "ladd",
        FADD to "fadd",
        DADD to "dadd",
        ISUB to "isub",
        LSUB to "lsub",
        FSUB to "fsub",
        DSUB to "dsub",
        IMUL to "imul",
        LMUL to "lmul",
        FMUL to "fmul",
        DMUL to "dmul",
        IDIV to "idiv",
        LDIV to "ldiv",
        FDIV to "fdiv",
        DDIV to "ddiv",
        IREM to "irem",
        LREM to "lrem",
        FREM to "frem",
        DREM to "drem",
        INEG to "ineg",
        LNEG to "lneg",
        FNEG to "fneg",
        DNEG to "dneg",
        ISHL to "ishl",
        LSHL to "lshl",
        ISHR to "ishr",
        LSHR to "lshr",
        IUSHR to "iushr",
        LUSHR to "lushr",
        IAND to "iand",
        LAND to "land",
        IOR to "ior",
        LOR to "lor",
        IXOR to "ixor",
        LXOR to "lxor",
        IINC to "iinc",
        I2L to "i2l",
        I2F to "i2f",
        I2D to "i2d",
        L2I to "l2i",
        L2F to "l2f",
        L2D to "l2d",
        F2I to "f2i",
        F2L to "f2l",
        F2D to "f2d",
        D2I to "d2i",
        D2L to "d2l",
        D2F to "d2f",
        I2B to "i2b",
        I2C to "i2c",
        I2S to "i2s",
        LCMP to "lcmp",
        FCMPL to "fcmpl",
        FCMPG to "fcmpg",
        DCMPL to "dcmpl",
        DCMPG to "dcmpg",
        IFEQ to "ifeq",
        IFNE to "ifne",
        IFLT to "iflt",
        IFGE to "ifge",
        IFGT to "ifgt",
        IFLE to "ifle",
        IF_ICMPEQ to "if_icmpeq",
        IF_ICMPNE to "if_icmpne",
        IF_ICMPLT to "if_icmplt",
        IF_ICMPGE to "if_icmpge",
        IF_ICMPGT to "if_icmpgt",
        IF_ICMPLE to "if_icmple",
        IF_ACMPEQ to "if_acmpeq",
        IF_ACMPNE to "if_acmpne",
        GOTO to "goto",
        JSR to "jsr",
        RET to "ret",
        TABLESWITCH to "tableswitch",
        LOOKUPSWITCH to "lookupswitch",
        IRETURN to "ireturn",
        LRETURN to "lreturn",
        FRETURN to "freturn",
        DRETURN to "dreturn",
        ARETURN to "areturn",
        RETURN to "return_void",
        GETSTATIC to "getstatic",
        PUTSTATIC to "putstatic",
        GETFIELD to "getfield",
        PUTFIELD to "putfield",
        INVOKEVIRTUAL to "invokevirtual",
        INVOKESPECIAL to "invokespecial",
        INVOKESTATIC to "invokestatic",
        INVOKEINTERFACE to "invokeinterface",
        INVOKEDYNAMIC to "invokedynamic",
        NEW to "new",
        NEWARRAY to "newarray",
        ANEWARRAY to "anewarray",
        ARRAYLENGTH to "arraylength",
        ATHROW to "athrow",
        CHECKCAST to "checkcast",
        INSTANCEOF to "instanceof",
        MONITORENTER to "monitorenter",
        MONITOREXIT to "monitorexit",
        MULTIANEWARRAY to "multianewarray",
        IFNULL to "ifnull",
        IFNONNULL to "ifnonnull"
)
