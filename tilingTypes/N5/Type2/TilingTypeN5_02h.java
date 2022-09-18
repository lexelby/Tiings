package tilingTypes.N5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN5_02h
   extends TilingType
{
   public TilingTypeN5_02h(){
      super( "N5-2h", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 70};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,1,2, 0},
            {0, 1,0, 0,0,1, 0},
            {1, 1,0, 2,1,2, 0},
      };
      info = "a=b=c\nA=E\nB=D\nA+C=180\n(A+2B=360)";
   }

   public void recalcBase(double[] paramValues) {
      double f = getParam(paramValues,0)/100.;
      double a = Functions.BisectionMethod(new Func(f), 84, 120, .0001);
      double b = 180-a/2;
      double lna = .6;
      double diagBE = 2*lna * Math.sin(a/2*DEG2RAD);
      double diagCE = Math.sqrt(diagBE*diagBE+lna*lna);
      double anECB = Math.asin(diagBE/diagCE)/DEG2RAD;
      double anDCE = 180-a - anECB;
      double anDEC = 3*a/2-180+anECB;
      double anCDE = 180-anDCE-anDEC;
      double lnc = diagCE / Math.sin(anCDE*DEG2RAD) * Math.sin(anDEC*DEG2RAD);

      double x4 =      lna*Math.cos( a * DEG2RAD);
      double y4 =      lna*Math.sin( a * DEG2RAD);
      double x1 = lna;
      double y1 = 0;
      double x2 = x1 + lna*Math.cos( (180-b) * DEG2RAD);
      double y2 = y1 + lna*Math.sin( (180-b) * DEG2RAD);
      double x3 = x2 + lnc*Math.cos( (180-b+a) * DEG2RAD);
      double y3 = y2 + lnc*Math.sin( (180-b+a) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(4)-tiles[3].getX(3);
      offsets[1] = tiles[1].getY(4)-tiles[3].getY(3);
      offsets[2] = tiles[0].getX(3)-tiles[1].getX(3);
      offsets[3] = tiles[0].getY(3)-tiles[1].getY(3);
   }

   private class Func
      implements IFunction
   {
      double f;
      public Func(double f0){ f = f0; }
      public double calculate(double a){
         double lna = .6;
         double diagBE = 2*lna * Math.sin(a/2*DEG2RAD);
         double diagCE = Math.sqrt(diagBE*diagBE+lna*lna);
         double anECB = Math.asin(diagBE/diagCE)/DEG2RAD;
         double anDCE = 180-a - anECB;
         double anDEC = 3*a/2-180+anECB;
         double anCDE = 180-anDCE-anDEC;
         double lnc = diagCE / Math.sin(anCDE*DEG2RAD) * Math.sin(anDEC*DEG2RAD);
         double lnd = calcSide(diagCE,lnc,anDCE);
         return lnc-f*(lnc+lnd);
      }
   }}
