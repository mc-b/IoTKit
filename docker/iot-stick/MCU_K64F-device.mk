# Vendor/device for which the library should be built.
MBED_DEVICE        := MCU_K64F
MBED_TARGET        := Freescale_K64F
MBED_CLEAN         := $(MBED_DEVICE)-MBED-clean
 
 
# Compiler flags which are specifc to this device.
TARGETS_FOR_DEVICE := TARGET_MCU_K64F TARGET_M4 TARGET_CORTEX_M TARGET_Freescale TARGET_KPSDK_MCUS TARGET_KPSDK_CODE TARGET_FRDM
TARGETS_FOR_DEVICE += TARGET_FF_ARDUINO TARGET_FF_MORPHO
GCC_DEFINES := $(patsubst %,-D%,$(TARGETS_FOR_DEVICE))
GCC_DEFINES += -D__CORTEX_M4 -DARM_MATH_CM4 -D__FPU_PRESENT=1 -DCPU_MK64FN1M0VLL12 -DTARGET_K64F -DCPU_MK64FN1M0VMD12
 
C_FLAGS   := -mcpu=cortex-m4 -mthumb -mfpu=fpv4-sp-d16 -mfloat-abi=softfp -mthumb-interwork
ASM_FLAGS := -mcpu=cortex-m4 -mthumb -mfpu=fpv4-sp-d16 -mfloat-abi=softfp
LD_FLAGS  := -mcpu=cortex-m4 -mthumb -mfpu=fpv4-sp-d16 -mfloat-abi=softfp
 
 
# Extra platform specific object files to link into file binary.
DEVICE_OBJECTS :=
 
 
# Version of MRI library to use for this device.
DEVICE_MRI_LIB :=
 
 
# Linker script to be used.  Indicates what code should be placed where in memory.
LSCRIPT=$(GCC4MBED_DIR)/external/mbed/libraries/mbed/targets/cmsis/TARGET_Freescale/TARGET_MCU_K64F/TOOLCHAIN_GCC_ARM/K64FN1M0xxx12.ld
 
include $(GCC4MBED_DIR)/build/device-common.mk
