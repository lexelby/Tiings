package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_213
   extends TilingType
{
   public TilingTypeNC5_213(){
      super( "NC5-213", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,180,100};
      paramDef = new int[]{ 30, 80, 80};
      paramName = new String[]{ "Aspect", "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 1,0, 0,0,1, 0},
            {0, 4,0, 1,0,4, 0},
            {1, 1,0, 2,0,1, 0},

            {1, 4,0, 1,2,3, 1},
            {0, 1,0, 4,0,1, 1},
            {0, 4,0, 5,0,4, 1},
            {1, 1,0, 6,0,1, 1},
      };
      info = "a=d\nC+E=180\nC+D=360\n(A+B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.5;
      double lna = lnt * getParam(paramValues,0)/100;
      double lnb = lnt - lna;
      double a = getParam(paramValues,1);

      double diag = calcSide(2*lna,lnb,a);
      double b = calcAngle(diag,lnb,2*lna);
      diag -= 2 * lna * Math.cos((180-a-b) * DEG2RAD);
      
      double lnc = diag * getParam(paramValues,2)/100;
      double lne = diag - lnc;

      double x4 = lna * Math.cos(a * DEG2RAD); 
      double y4 = lna * Math.sin(a * DEG2RAD);
      double c = Math.cos(b * DEG2RAD); 
      double s = Math.sin(b * DEG2RAD);

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, lnb, 0);
      baseTile.setPoint(2, lnb-c*lnc, s*lnc);
      baseTile.setPoint(3, x4+c*lne, y4-s*lne);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[3].getX(2);
      offsets[1] = tiles[0].getY(3)-tiles[3].getY(2);
      offsets[2] = tiles[6].getX(3)-tiles[3].getX(0);
      offsets[3] = tiles[6].getY(3)-tiles[3].getY(0);
   }
}
