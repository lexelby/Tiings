package tilingTypes.NC6.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_73
   extends TilingType
{
   public TilingTypeNC6_73(){
      super( "NC6-73", 6, SymmetryType.p3 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{300,100};
      paramDef = new int[]{100, 40};
      paramName = new String[]{"Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 4,0, 0,4,2, 0},
            {0, 4,0, 1,4,2, 0},
      };
      info = "a=d\nb=c\ne=f\nB=120\nE=120\nD+F=360\n(A+C=120)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .8;
      
      double w = ln/2;
      double h = w * Math.sqrt(3);
      double a = getParam(paramValues,0);
      double z = Math.abs((a%60)-30);
      double rmax = h/Math.cos((30-z)*DEG2RAD);
      double r = rmax * getParam(paramValues,1)/100;
      
      double c1 = r * Math.cos((150-a) * DEG2RAD);
      double s1 = r * Math.sin((150-a) * DEG2RAD);
      double c2 = r * Math.cos((30-a) * DEG2RAD);
      double s2 = r * Math.sin((30-a) * DEG2RAD);
      
      baseTile.setPoint(0,     0,  0);
      baseTile.setPoint(1,   2*w,  0);
      baseTile.setPoint(2,   3*w,  h);
      baseTile.setPoint(3,  w+c1,  h+s1);
      baseTile.setPoint(4,     w,  h);
      baseTile.setPoint(5,  w+c2,  h+s2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[1].getY(2)-tiles[0].getY(0);
   }
}