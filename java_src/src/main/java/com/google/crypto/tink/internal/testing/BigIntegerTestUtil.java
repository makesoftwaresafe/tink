// Copyright 2023 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specified language governing permissions and
// limitations under the License.
//
////////////////////////////////////////////////////////////////////////////////

package com.google.crypto.tink.internal.testing;

/** Test helpers for BigInteger usage. */
public final class BigIntegerTestUtil {
  /**
   * Adds a leading zero to the big-endian encoding, if necessary.
   *
   * <p>When encoding a BigInteger using `toBigEndianBytes()`, the minimal big-endian encoding uses
   * the two's complement representation. This means that the encoding may have a leading zero.
   */
  public static byte[] ensureLeadingZeroBit(byte[] minimalEncodedBigInteger) {
    if (minimalEncodedBigInteger[0] < 0) {
      // Add a leading zero to the encoding.
      byte[] twosComplementEncoded = new byte[minimalEncodedBigInteger.length + 1];
      System.arraycopy(
          minimalEncodedBigInteger, 0, twosComplementEncoded, 1, minimalEncodedBigInteger.length);
      return twosComplementEncoded;
    }
    return minimalEncodedBigInteger;
  }

  private BigIntegerTestUtil() {}
}
