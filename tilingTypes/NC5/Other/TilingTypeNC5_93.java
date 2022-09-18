package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_93
   extends TilingType
   implements IFunction
{
   public TilingTypeNC5_93(){
      super( "NC5-93", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,2, 0,0,3, 0},
            {1, 3,2, 1,2,3, 0},
            {0, 0,3, 2,0,2, 0},

            {0, 1,0, 0,3,2, 1},
            {1, 0,2, 4,0,3, 1},
            {1, 3,2, 5,2,3, 1},
            {0, 0,3, 6,0,2, 1},
      };
      info = "a=b\nc=e\nd=2a\nA=90\nB+E=360\nC+E=180\n(E=D+90)";
   }
   private double ln1, x2, y2;
   public void initialiseImpl(){
      ln1 = .75;
      double b = Functions.BisectionMethod(this, 180,270, 0.0001);
      double c = Math.cos(b * DEG2RAD);
      double s = Math.sin(b * DEG2RAD);
      double ln2 = ln1*(Math.sqrt(1+c*c) + c);
      x2 = ln1-ln2*c;
      y2 = ln2*s;
   }   

   public void recalcBase(double[] paramValues) {
     
      baseTile.setPoint(0,   0,    0);
      baseTile.setPoint(1, ln1,    0);
      baseTile.setPoint(2,  x2,   y2);
      baseTile.setPoint(3, -y2,   x2);
      baseTile.setPoint(4,   0,  ln1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(4)-tiles[2].getX(4);
      offsets[1] = tiles[1].getY(4)-tiles[2].getY(4);
      offsets[2] = tiles[0].getX(2)-tiles[3].getX(2);
      offsets[3] = tiles[0].getY(2)-tiles[3].getY(2);
   }

   public double calculate(double b){
      double c = Math.cos(b * DEG2RAD);
      double s = Math.sin(b * DEG2RAD);
      // (1-c*L)^2 + L^2 s^2 = 2
      // 1-2cL+c2L2 + L^2 s^2 = 2
      // 1- 2cL + L^2 = 2
      // L^2 - 2cL -1 = 0
      // (L-c)^2 = 1+c^2
      double ln = Math.sqrt(1+c*c) + c;
      double dy = 1-ln*c-ln*s;
      double dx = 1-ln*c+ln*s;
      double angx= Math.atan2(dy,dx)/DEG2RAD;
      // b-c=180
      // c = angx+180-b
      // -2b+angx+360=0
      return angx+360-2*b;
   }
   
}
