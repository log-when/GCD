circuit DecoupledGcdProp1 :
  module DecoupledGcdProp1 :
    input clock : Clock
    input reset : UInt<1>
    output input_ready : UInt<1>
    input input_valid : UInt<1>
    input input_bits_value1 : UInt<4>
    input input_bits_value2 : UInt<4>
    input output_ready : UInt<1>
    output output_valid : UInt<1>
    output output_bits_value1 : UInt<4>
    output output_bits_value2 : UInt<4>
    output output_bits_gcd : UInt<4>

    reg xInitial : UInt<4>, clock with :
      reset => (UInt<1>("h0"), xInitial) @[GCD.scala 28:24]
    reg yInitial : UInt<4>, clock with :
      reset => (UInt<1>("h0"), yInitial) @[GCD.scala 29:24]
    reg x : UInt<4>, clock with :
      reset => (UInt<1>("h0"), x) @[GCD.scala 30:24]
    reg y : UInt<4>, clock with :
      reset => (UInt<1>("h0"), y) @[GCD.scala 31:24]
    reg busy : UInt<1>, clock with :
      reset => (UInt<1>("h0"), busy) @[GCD.scala 32:28]
    reg resultValid : UInt<1>, clock with :
      reset => (UInt<1>("h0"), resultValid) @[GCD.scala 33:28]
    node _input_ready_T = eq(busy, UInt<1>("h0")) @[GCD.scala 35:18]
    node _T = geq(x, y) @[GCD.scala 46:12]
    node _x_T = sub(x, y) @[GCD.scala 47:14]
    node _x_T_1 = tail(_x_T, 1) @[GCD.scala 47:14]
    node _y_T = sub(y, x) @[GCD.scala 49:14]
    node _y_T_1 = tail(_y_T, 1) @[GCD.scala 49:14]
    node _GEN_0 = mux(_T, _x_T_1, x) @[GCD.scala 46:18 30:24 47:9]
    node _GEN_1 = mux(_T, y, _y_T_1) @[GCD.scala 46:18 31:24 49:9]
    node _T_1 = eq(x, UInt<1>("h0")) @[GCD.scala 51:12]
    node _T_2 = eq(y, UInt<1>("h0")) @[GCD.scala 51:25]
    node _T_3 = or(_T_1, _T_2) @[GCD.scala 51:20]
    node _T_4 = eq(x, UInt<1>("h0")) @[GCD.scala 52:14]
    node _GEN_2 = mux(_T_4, y, x) @[GCD.scala 52:23 53:25 55:25]
    node _GEN_3 = mux(resultValid, UInt<1>("h0"), UInt<1>("h1")) @[GCD.scala 60:19 63:25 64:21]
    node _GEN_4 = validif(_T_3, _GEN_2) @[GCD.scala 51:34]
    node _GEN_5 = validif(_T_3, xInitial) @[GCD.scala 51:34 58:26]
    node _GEN_6 = validif(_T_3, yInitial) @[GCD.scala 51:34 59:26]
    node _GEN_7 = mux(_T_3, _GEN_3, resultValid) @[GCD.scala 33:28 51:34]
    node _GEN_8 = mux(_T_3, UInt<1>("h0"), busy) @[GCD.scala 51:34 61:12 32:28]
    node _GEN_9 = mux(input_valid, UInt<1>("h1"), _input_ready_T) @[GCD.scala 68:23 Decoupled.scala 81:20 GCD.scala 35:15]
    node _GEN_10 = mux(input_valid, input_bits_value1, x) @[GCD.scala 68:23 30:24 70:9]
    node _GEN_11 = mux(input_valid, input_bits_value2, y) @[GCD.scala 68:23 31:24 71:9]
    node _GEN_12 = mux(input_valid, input_bits_value1, xInitial) @[GCD.scala 68:23 72:16 28:24]
    node _GEN_13 = mux(input_valid, input_bits_value2, yInitial) @[GCD.scala 68:23 73:16 29:24]
    node _GEN_14 = mux(input_valid, UInt<1>("h1"), busy) @[GCD.scala 68:23 74:12 32:28]
    node _GEN_15 = mux(busy, _GEN_0, _GEN_10) @[GCD.scala 45:15]
    node _GEN_16 = mux(busy, _GEN_1, _GEN_11) @[GCD.scala 45:15]
    node _GEN_17 = validif(busy, _GEN_4) @[GCD.scala 45:15]
    node _GEN_18 = validif(busy, _GEN_5) @[GCD.scala 45:15]
    node _GEN_19 = validif(busy, _GEN_6) @[GCD.scala 45:15]
    node _GEN_20 = mux(busy, _GEN_7, resultValid) @[GCD.scala 45:15 33:28]
    node _GEN_21 = mux(busy, _GEN_8, _GEN_14) @[GCD.scala 45:15]
    node _GEN_22 = mux(busy, _input_ready_T, _GEN_9) @[GCD.scala 35:15 45:15]
    node _GEN_23 = mux(busy, xInitial, _GEN_12) @[GCD.scala 45:15 28:24]
    node _GEN_24 = mux(busy, yInitial, _GEN_13) @[GCD.scala 45:15 29:24]
    node _T_5 = eq(busy, UInt<1>("h0")) @[GCDTest.scala 19:65]
    input_ready <= _GEN_22
    output_valid <= resultValid @[GCD.scala 36:16]
    output_bits_value1 <= _GEN_18
    output_bits_value2 <= _GEN_19
    output_bits_gcd <= _GEN_17
    xInitial <= _GEN_23
    yInitial <= _GEN_24
    x <= _GEN_15
    y <= _GEN_16
    busy <= mux(reset, UInt<1>("h0"), _GEN_21) @[GCD.scala 32:{28,28}]
    resultValid <= mux(reset, UInt<1>("h0"), _GEN_20) @[GCD.scala 33:{28,28}]
