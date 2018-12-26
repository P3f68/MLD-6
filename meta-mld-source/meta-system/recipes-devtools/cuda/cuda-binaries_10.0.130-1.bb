require cuda-binaries-common.inc

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://usr/local/cuda-10.0/LICENSE;md5=d87e5ceb8a41dd716b3205c4e00aa729 \
            file://usr/local/cuda-10.0/doc/EULA.txt;md5=1d9340fbe1f77282520c3ef05235c26a"

SRC_URI = "https://developer.download.nvidia.com/compute/cuda/repos/ubuntu1804/x86_64/cuda-core-10-0_${PV}_amd64.deb"
SRC_URI[md5sum] = "306fbaad179372f5f200c8d2c2c9b8bb"
SRC_URI[sha256sum] = "02cced9392175cd0983c34dc774bd296c75f7d556ce8eae35787f041e70b6e94"
do_unpack[depends] += "xz-native:do_populate_sysroot"

#COMPATIBLE_MACHINE = "(tegra186|tegra210)"

PR = "r0"
