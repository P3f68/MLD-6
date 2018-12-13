require linux.inc
require kselftests.inc

SUMMARY = "Linux kernel for ${MACHINE}"
SECTION = "kernel"
LICENSE = "GPLv2"
PACKAGE_ARCH = "${MACHINE_ARCH}"
KCONFIG_MODE = "--allnoconfig"
PR ?= "MLD"
SRC = "20151106"


LINUX_VERSION_EXTENSION_append = "-x86"
inherit kernel pkgconfig

LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING.GPL;md5=751419260aa954499f7abaabaa882bbe"


# By default, kernel.bbclass modifies package names to allow multiple kernels
# to be installed in parallel. We revert this change and rprovide the versioned
# package names instead, to allow only one kernel to be installed.
#PKG_kernel-base = "kernel-base"
#PKG_kernel-image = "kernel-image"
#RPROVIDES_kernel-base = "kernel-${KERNEL_VERSION}"
#RPROVIDES_kernel-image = "kernel-image-${KERNEL_VERSION}"
#FILES_kernel-image = "${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}.gz"

KERNEL_VERSION_NAME = "${@d.getVar('KERNEL_VERSION') or ""}"
KERNEL_VERSION_NAME[vardepvalue] = "${LINUX_VERSION}"
KERNEL_VERSION_PKG_NAME = "${@legitimize_package_name(d.getVar('KERNEL_VERSION'))}"
KERNEL_VERSION_PKG_NAME[vardepvalue] = "${LINUX_VERSION}"

KMACHINE_genericx86 ?= "common-pc"
KMACHINE_genericx86-64 ?= "common-pc-64"


# Functionality flags
KERNEL_EXTRA_FEATURES ?= "features/netfilter/netfilter.scc features/taskstats/taskstats.scc"
KERNEL_FEATURES_append = " ${KERNEL_EXTRA_FEATURES}"
KERNEL_FEATURES_append = " ${@bb.utils.contains("TUNE_FEATURES", "mx32", " cfg/x32.scc", "" ,d)}"

# Kernel 3.16.1
#KERNEL_VERSION ?= "3.16"
#PV ?= "3.16.1"
#SRCREV = "9a35988df62b6ce3b69d640da44a3ead96f63182"

# Kernel 3.16.6
#KERNEL_VERSION ?= "3.16"
#PV ?= "3.16.6"
#SRCREV = "6c11524352981b8276e8ded1c7b962a019f7967d"

# Kernel 3.16.7
#KERNEL_VERSION ?= "3.16"
#PV ?= "3.16.7"
#SRCREV = "d0335e4feea0d3f7a8af3116c5dc166239da7521"

# Kernel 3.17.1
#KERNEL_VERSION ?= "3.17"
#PV ?= "3.17.1"
#SRCREV = "9db8a8bb98cf75b0a51d66f560c87028e93a8ed8"
    
# Kernel 3.19.1
#KERNEL_VERSION ?= "3.19"
#PV ?= "3.19.1"
#SRCREV = "5392bc6bce5ff16ca78d7d3780bde272f9119bb8"

# Kernel 3.19.8
#KERNEL_VERSION ?= "3.19"
#PV ?= "3.19.8"
#SRCREV = "fcf4fe0e3e820408890ae137a684e56010c55f99"

# Kernel 4.3.3
#KERNEL_VERSION ?= "4.3"
#PV ?= "4.3.3"
#SRCREV = "09f6b0600c331c69cdc8ba5d9152fe171745d8fd"

# Kernel 4.4
#KERNEL_VERSION ?= "4.4"
#PV ?= "4.4"
#SRCREV = "afd2ff9b7e1b367172f18ba7f693dfb62bdcb2dc"
 
# Kernel 4.5
#KERNEL_VERSION ?= "4.5"
#PV ?= "4.5"
#SRCREV = "a26555498849489fb87139a15abe2eeb8a366ae7"
 
# Kernel 4.6
#KERNEL_VERSION ?= "4.6"
#PV ?= "4.6"
#SRCREV = "536b1f59b9b2be80e5cdc02ca3300d7fe9f44cc1"
 
# Kernel 4.8.15
#KERNEL_VERSION ?= "4.8"
#PV ?= "4.8.15"
#SRCREV = "1553da43c6a908d24ae2dd269dcc43e9cd226d70"

# Kernel 4.10.1
#KERNEL_VERSION ?= "4.10"
#PV ?= "4.10.1"
#SRCREV = "d23a9821d3972ae373357e933c8af8216d72e374"

# Kernel 4.12.10
#KERNEL_VERSION ?= "4.12"
#PV ?= "4.12.10"
#SRCREV = "d23a9821d3972ae373357e933c8af8216d72e374"

# Kernel 4.13.2
#KERNEL_VERSION ?= "4.13"
#PV ?= "4.13.2"
#SRCREV = "07dd6cc1fff160143e82cf5df78c1db0b6e03355"

# Kernel 4.13.14
#KERNEL_VERSION ?= "4.13"
#PV ?= "4.13.14"
#SRCREV = "b1d6a6ff22862dfca8006afe2a6cdcb28c35b002"

# Kernel 4.14
#KERNEL_VERSION ?= "4.14"
#PV ?= "4.14"
#SRCREV = "bebc6082da0a9f5d47a1ea2edc099bf671058bd4"

# Kernel 4.14.1
#KERNEL_VERSION ?= "4.14"
#PV ?= "4.14.1"
#SRCREV = "62b0ea074a9aeec15ea2217a97273070101bf185"

# Kernel 4.14.2
#KERNEL_VERSION ?= "4.14"
#PV ?= "4.14.2"
#SRCREV = "8292fd8d726105abc01dae26d0a2cddcf53d4e0f"

# Kernel 4.16.6
#KERNEL_VERSION ?= "4.16"
#PV ?= "4.16.6"
#SRCREV = "cf94ecafe6ef3fb9ba94084666c9b7ef5433d436"

# Kernel 4.18.16
#LINUX_VERSION ?= "4.18.16"
#SRCREV = "94710cac0ef4ee177a63b5227664b38c95bbf703"

# Kernel 4.19.9
LINUX_VERSION ?= "4.19.9"
SRCREV = "0fc19a8881e68ccbd252e2916756c7b6a7bec65c"
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-4.19.y"

SRC_URI += " file://linux.config.x86 \
             file://COPYING.GPL \
        "

PV = "${LINUX_VERSION}"

S = "${WORKDIR}/git"


export OS = "Linux"
KERNEL_OBJECT_SUFFIX = "ko"
KERNEL_IMAGEDEST = "/tmp"

# make[3]: *** [scripts/extract-cert] Error 1
DEPENDS += "openssl-native"
DEPENDS += "${@bb.utils.contains('ARCH', 'x86', 'elfutils-native', '', d)}"
HOST_EXTRACFLAGS += "-I${STAGING_INCDIR_NATIVE}"

do_configure() {
    touch ${B}/.scmversion ${S}/.scmversion

    # While kernel.bbclass has an architecture mapping, we can't use it because
    # the kernel config file has a different name.
    case "${HOST_ARCH}" in
      aarch64)
        cp ${S}/arch/arm64/configs/defconfig ${B}/.config
        # https://bugs.linaro.org/show_bug.cgi?id=3769
        echo 'CONFIG_ARM64_MODULE_PLTS=y' >> ${B}/.config
      ;;
      arm)
        cp ${S}/arch/arm/configs/multi_v7_defconfig ${B}/.config
        echo 'CONFIG_ARM_TI_CPUFREQ=y' >> ${B}/.config
        echo 'CONFIG_SERIAL_8250_OMAP=y' >> ${B}/.config
        echo 'CONFIG_POSIX_MQUEUE=y' >> ${B}/.config
      ;;
      x86_64)
        cp ${S}/arch/x86/configs/x86_64_defconfig ${B}/.config
        echo 'CONFIG_IGB=y' >> ${B}/.config
        # FIXME https://bugs.linaro.org/show_bug.cgi?id=3459
        # x86 fails to build:
        # | kernel-source/Makefile:938:
        # *** "Cannot generate ORC metadata for CONFIG_UNWINDER_ORC=y,
        # please install libelf-dev, libelf-devel or elfutils-libelf-devel".  Stop.
        echo 'CONFIG_UNWINDER_FRAME_POINTER=y' >> ${B}/.config
        echo '# CONFIG_UNWINDER_ORC is not set' >> ${B}/.config
      ;;
      i686)
        cp ${S}/arch/x86/configs/i386_defconfig ${B}/.config
        echo 'CONFIG_IGB=y' >> ${B}/.config
        # FIXME https://bugs.linaro.org/show_bug.cgi?id=3459
        # x86 fails to build:
        # | kernel-source/Makefile:938:
        # *** "Cannot generate ORC metadata for CONFIG_UNWINDER_ORC=y,
        # please install libelf-dev, libelf-devel or elfutils-libelf-devel".  Stop.
        echo 'CONFIG_UNWINDER_FRAME_POINTER=y' >> ${B}/.config
        echo '# CONFIG_UNWINDER_ORC is not set' >> ${B}/.config
      ;;
    esac

    # Check for kernel config fragments. The assumption is that the config
    # fragment will be specified with the absolute path. For example:
    #   * ${WORKDIR}/config1.cfg
    #   * ${S}/config2.cfg
    # Iterate through the list of configs and make sure that you can find
    # each one. If not then error out.
    # NOTE: If you want to override a configuration that is kept in the kernel
    #       with one from the OE meta data then you should make sure that the
    #       OE meta data version (i.e. ${WORKDIR}/config1.cfg) is listed
    #       after the in-kernel configuration fragment.
    # Check if any config fragments are specified.
    if [ ! -z "${KERNEL_CONFIG_FRAGMENTS}" ]; then
        for f in ${KERNEL_CONFIG_FRAGMENTS}; do
            # Check if the config fragment was copied into the WORKDIR from
            # the OE meta data
            if [ ! -e "$f" ]; then
                echo "Could not find kernel config fragment $f"
                exit 1
            fi
        done

        # Now that all the fragments are located merge them.
        ( cd ${WORKDIR} && ${S}/scripts/kconfig/merge_config.sh -m -r -O ${B} ${B}/.config ${KERNEL_CONFIG_FRAGMENTS} 1>&2 )
    fi

    oe_runmake -C ${S} O=${B} olddefconfig

    oe_runmake -C ${S} O=${B} kselftest-merge

    bbplain "Saving defconfig to:\n${B}/defconfig"
    oe_runmake -C ${B} savedefconfig
}

do_deploy_append() {
    cp -a ${B}/defconfig ${DEPLOYDIR}
    cp -a ${B}/.config ${DEPLOYDIR}/config
    cp -a ${B}/vmlinux ${DEPLOYDIR}
    cp ${T}/log.do_compile ${T}/log.do_compile_kernelmodules ${DEPLOYDIR}

    # FIXME 410c fails to build when skales in invoked
    # |   File "/usr/bin/skales/dtbTool", line 239, in __init__
    # |     self.msm_id[0] = soc_ids[matches['soc']] | (foundry << 16)
    # | KeyError: u'ipq8074'
    ( cd ${B}/arch/arm64/boot/dts/qcom/ && rm -vf *ipq8074* *sdm845* ) || true
}

do_rm_work() {
}
