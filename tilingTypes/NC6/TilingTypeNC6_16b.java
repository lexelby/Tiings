package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_16b
   extends TilingType
{
   public TilingTypeNC6_16b(){
      super( "NC6-16b", 6, SymmetryType.pgg );

      paramMin = new int[]{ 36};
      paramMax = new int[]{135};
      paramDef = new int[]{102};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,1,2, 0},
            {0, 2,3, 0,3,2, 0},
            {1, 1,0, 2,1,2, 0},

            {0, 0,1, 1,1,2, 1},
            {1, 1,0, 4,1,2, 1},
            {0, 2,3, 4,3,2, 1},
            {1, 1,0, 6,1,2, 1},
      };
      info = "b=c\na=d=e=f\nB=E\nD+F=360\n2E+F=360\n(A+C=F)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .7;
      double a = getParam(paramValues, 0);
      
      double c = ln * Math.cos( a * DEG2RAD );
      double s = ln * Math.sin( a * DEG2RAD );

      double h =  Math.tan((a-90) * DEG2RAD) * (ln/2);
      double ln2 = Math.sqrt(h*h+ln*ln/4);
      
      baseTile.setPoint(0,     0,     0);
      baseTile.setPoint(1,    ln,     0);
      baseTile.setPoint(2,  ln-c,     s);
      baseTile.setPoint(3,ln/2-c,   s-h);
      baseTile.setPoint(4,    -c,     s);
      baseTile.setPoint(5,     0,   ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[7].getX(2)-tiles[3].getX(1);
      offsets[3] = tiles[7].getY(2)-tiles[3].getY(1);
   }
}